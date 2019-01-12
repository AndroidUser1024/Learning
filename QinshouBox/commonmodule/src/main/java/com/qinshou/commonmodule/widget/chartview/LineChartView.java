package com.qinshou.commonmodule.widget.chartview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;


import com.qinshou.commonmodule.widget.chartview.component.Axis;
import com.qinshou.commonmodule.widget.chartview.component.AxisText;
import com.qinshou.commonmodule.widget.chartview.component.DataLine;
import com.qinshou.commonmodule.widget.chartview.component.DataPoint;
import com.qinshou.commonmodule.widget.chartview.component.HighlightDataPoint;
import com.qinshou.commonmodule.widget.chartview.component.HorizontalLine;
import com.qinshou.commonmodule.widget.chartview.listener.IOnDataPointSelectedListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:折线图控件，支持多条数据线、自定义标签、添加水平辅助线、高亮数据点、触摸事件，还有贝塞尔曲线样式和动态绘制
 * Date:2018/12/25
 */
public class LineChartView extends View {
    private int mWidth;
    private int mHeight;

    private Paint mBgPaint;   //背景的画笔
    private int mBgColor;    //背景颜色
    private RectF mBgStroke;   //背景边框
    private int mBgStrokeWidth = 1;
    private int mBgStrokeColor;    //背景边框颜色
    private float mBgStrokeRadius; //背景边框的圆角度

    private List<DataLine> mDataLineList = new ArrayList<>(); //数据线的集合
    private Paint mDataLinePaint;   //数据线的画笔
    private float eachX;    //横轴每一单元的长度
    private float eachY;    //纵轴每一单元的长度
    private float yMax;     //纵轴最大值
    private float yMin;     //纵轴最小值

    private static final float SMOOTHNESS = 0.25f;  //贝塞尔曲线平滑度

    private float chartPaddingTop;
    private float chartPaddingBottom;

    private List<HorizontalLine> mHorizontalLineList = new ArrayList<>();    //水平线的集合，该水平线为辅助线
    private Paint mHorizontalLinePaint;   //水平辅助线的画笔

    private Map<Axis.Type, Axis> mAxisMap = new HashMap<>();   //轴的集合，最多只能有两条，X 轴和 Y 轴
    private Axis mAxisX;    //X 轴标签
    private Axis mAxisY;    //Y 轴标签

    private List<HighlightDataPoint> mHighlightDataPointList = new ArrayList<>();    //高亮数据点的集合
    private Paint mHighlightDataPointPaint;   //高亮数据点的画笔

    private Paint mTouchLinePaint;  //触摸点最近的数据点的横纵轴线的画笔
    private boolean mShowTouchLineX = true;  //触摸图表时是否显示触摸点最近的数据点的横轴线
    private boolean mShowTouchLineY = true;  //触摸图表时是否显示触摸点最近的数据点的纵轴线
    private boolean mShowTouchLinePoint = true;  //触摸图表时是否显示触摸点最近的数据点
    private boolean mShowTouchLinePointText = true;  //触摸图表时是否显示触摸点最近的数据点的文字
    private float mTouchLineWidth;    //触摸指示线的宽度
    private int mTouchLineColor;    //触摸指示线的颜色
    private float mTouchLineTextSize;    //触摸指示线的文字大小
    private int mTouchLineTextColor;    //触摸指示线的文字颜色

    private boolean mTouching;   //是否正在触摸图表的标志位
    private int touchPosition = -1; //触摸图表时最近的数据点的 position
    private IOnDataPointSelectedListener mOnDataPointSelectedListener;  //触摸图表时最近的的数据点的回调监听

    private boolean mAnimateDraw = false;    //是否动态绘制的标志位
    private SparseArray<Path> mDataLinePathSparseArray = new SparseArray<>();
    private SparseArray<Path> mDataLineAnimatePathSparseArray = new SparseArray<>();
    private boolean mAnimateDrawing = false;    //是否正在进行动态绘制

    public LineChartView(Context context) {
        this(context, null);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            setLayerType(LAYER_TYPE_SOFTWARE, null);
        }
        initPaint(context);
        mBgColor = Color.GRAY;
        mBgStroke = new RectF();
        mBgStrokeColor = Color.BLACK;
        mBgStrokeRadius = 0;

        mTouchLineWidth = 1f;
        mTouchLineColor = Color.BLACK;
        mTouchLineTextSize = 20f;
        mTouchLineTextColor = Color.BLACK;
    }

    private void initPaint(Context context) {
        mBgPaint = new Paint();
        mBgPaint.setAntiAlias(true);
        mBgPaint.setStrokeWidth(1f);

        mDataLinePaint = new Paint();
        mDataLinePaint.setAntiAlias(true);

        mHorizontalLinePaint = new Paint();
        mHorizontalLinePaint.setAntiAlias(true);

        mHighlightDataPointPaint = new Paint();
        mHighlightDataPointPaint.setAntiAlias(true);
        mHighlightDataPointPaint.setStyle(Paint.Style.FILL);

        mTouchLinePaint = new Paint();
        mTouchLinePaint.setAntiAlias(true);
        mTouchLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize;
        } else {
            //当未指定具体宽时，宽为屏幕宽
            mWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
        } else {
            //当未指定具体高时，高为屏幕高的一半
            mHeight = getContext().getResources().getDisplayMetrics().heightPixels / 2;
        }
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //画背景及边框
        drawBackground(canvas);
        //画层级处于数据线之下的水平辅助线
        for (int i = 0; i < mHorizontalLineList.size(); i++) {
            HorizontalLine horizontalLine = mHorizontalLineList.get(i);
            if (horizontalLine.getLevel() == HorizontalLine.Level.BELOW_DATA_LINE) {
                drawHorizontalLine(canvas, horizontalLine);
            }
        }
        //画数据线
        for (int i = 0; i < mDataLineList.size(); i++) {
            drawDataLine(canvas, mDataLineList.get(i));
        }
        //画层级处于数据线之上的水平辅助线
        for (int i = 0; i < mHorizontalLineList.size(); i++) {
            HorizontalLine horizontalLine = mHorizontalLineList.get(i);
            if (horizontalLine.getLevel() == HorizontalLine.Level.ABOVE_DATA_LINE) {
                drawHorizontalLine(canvas, horizontalLine);
            }
        }

        //画横纵轴
        for (Map.Entry<Axis.Type, Axis> entry : mAxisMap.entrySet()) {
            drawAxis(canvas, entry.getValue());
        }
        //画高亮数据点
        if (!mAnimateDrawing) {
            for (int i = 0; i < mHighlightDataPointList.size(); i++) {
                drawHighlightPoint(canvas, mHighlightDataPointList.get(i));
            }
        }
        //画触摸位置
        if (mTouching && touchPosition > -1) {
            drawTouchPosition(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < getPaddingLeft()
                        || event.getX() > mWidth - getPaddingRight()
                        || event.getY() < getPaddingTop()
                        || event.getY() > mHeight - getPaddingBottom()
                        || eachX == 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
                //使父布局不拦截触摸事件
                getParent().requestDisallowInterceptTouchEvent(true);
                mTouching = true;
                touchPosition = (int) ((event.getX() - getPaddingLeft()) / eachX);
                if (((event.getX() - getPaddingLeft()) % eachX) > eachX / 2) {
                    touchPosition++;
                }
                if (mOnDataPointSelectedListener != null) {
                    mOnDataPointSelectedListener.onDataPointSelected(event.getRawX(), event.getRawY(), touchPosition);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getX() < getPaddingLeft()
                        || event.getX() > mWidth - getPaddingRight()
                        || event.getY() < getPaddingTop()
                        || event.getY() > mHeight - getPaddingBottom()
                        || eachX == 0) {
                    mTouching = false;
                    touchPosition = -1;
                    invalidate();
                    return false;
                }
                mTouching = true;
                touchPosition = (int) ((event.getX() - getPaddingRight()) / eachX);
                if (((event.getX() - getPaddingRight()) % eachX) > eachX / 2) {
                    touchPosition++;
                }
                if (mOnDataPointSelectedListener != null) {
                    mOnDataPointSelectedListener.onDataPointSelected(event.getRawX(), event.getRawY(), touchPosition);
                }
                break;
            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(false);
                mTouching = false;
                touchPosition = -1;
                if (mOnDataPointSelectedListener != null) {
                    mOnDataPointSelectedListener.onDataPointCancelSelected();
                }
                break;
        }
        invalidate();
        return true;
    }

    /**
     * Create By:禽兽先生
     * Create On:2018/12/22 17:07
     * Description:画背景及边框
     */
    protected void drawBackground(Canvas canvas) {
        //设置圆角矩形的宽高
        mBgStroke.set(getPaddingLeft() + mBgPaint.getStrokeWidth()
                , getPaddingTop() + mBgPaint.getStrokeWidth()
                , mWidth - getPaddingRight() - mBgPaint.getStrokeWidth()
                , mHeight - getPaddingBottom() - mBgPaint.getStrokeWidth());

        //画背景
        mBgPaint.setStyle(Paint.Style.FILL);
        mBgPaint.setStrokeWidth(mBgStrokeWidth);
        mBgPaint.setColor(mBgColor);
        canvas.drawRoundRect(mBgStroke, mBgStrokeRadius, mBgStrokeRadius, mBgPaint);

        //画背景边框
        mBgPaint.setStyle(Paint.Style.STROKE);
        mBgPaint.setColor(mBgStrokeColor);
        canvas.drawRoundRect(mBgStroke, mBgStrokeRadius, mBgStrokeRadius, mBgPaint);
    }

    /**
     * Create By:禽兽先生
     * Create On:2018/12/22 0022 17:07
     * Description:画数据线
     */
    private void drawDataLine(Canvas canvas, DataLine dataLine) {
        Path path;
        if (mAnimateDraw) {
            //如果动态绘制，则 path 为拷贝的动态 path
            path = mDataLineAnimatePathSparseArray.get(dataLine.hashCode());
        } else {
            //否则直接拿到 path
            path = getDataLinePath(dataLine);
        }
        if (path == null) {
            return;
        }
        //画填充部分
        if (dataLine.isFill()) {
            Path fillPath = new Path(path);
            PathMeasure pathMeasure = new PathMeasure(fillPath, false);
            float[] pos = new float[2];
            float[] tan = new float[2];
            pathMeasure.getPosTan(pathMeasure.getLength(), pos, tan);
            //连接 path 最后一点和横轴上与其横坐标相等的点
            fillPath.lineTo(pos[0]
                    , mHeight - getPaddingBottom() - mBgPaint.getStrokeWidth()
            );
            //连接图表左下角的点
            fillPath.lineTo(getPaddingLeft() + mBgPaint.getStrokeWidth()
                    , mHeight - getPaddingBottom() - mBgPaint.getStrokeWidth()
            );
            pathMeasure.getPosTan(0, pos, tan);
            //连接第一个数据点，也就是 path 第一个点，也可以使用
//            pathMeasure.getPosTan(0, pos, tan);
//            fillPath.lineTo(pos[0],pos[1]);
            fillPath.lineTo(eachX * dataLine.getDataPointList().get(0).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                    , eachY * (yMax - dataLine.getDataPointList().get(0).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth()
            );
            //重新设置画笔画填充部分
            mDataLinePaint.setStrokeWidth(1f);
            mDataLinePaint.setStyle(Paint.Style.FILL);
            mDataLinePaint.setShader(new LinearGradient(0
                    , eachY * (yMax - dataLine.getMax()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                    , 0
                    , mHeight - getPaddingBottom() - mBgPaint.getStrokeWidth()
                    , dataLine.getFillColors()
                    , null
                    , Shader.TileMode.CLAMP));
            canvas.drawPath(fillPath, mDataLinePaint);
        }
        //画数据线
        mDataLinePaint.setStrokeWidth(dataLine.getWidth());
        mDataLinePaint.setStyle(Paint.Style.STROKE);
        mDataLinePaint.setShader(null);
        mDataLinePaint.setColor(dataLine.getColor());
        canvas.drawPath(path, mDataLinePaint);
    }

    private Path getDataLinePath(DataLine dataLine) {
        //先从容器中取，如果没有再创建并存到容器中
        Path path = mDataLinePathSparseArray.get(dataLine.hashCode());
        if (path == null) {
            path = new Path();
            mDataLinePathSparseArray.put(dataLine.hashCode(), path);
            if (dataLine.getType() == DataLine.Type.LINEAR) {
                //普通折线图
                for (int i = 0; i < dataLine.getDataPointList().size(); i++) {
                    if (i == 0) {
                        path.moveTo(eachX * dataLine.getDataPointList().get(i).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                , eachY * (yMax - dataLine.getDataPointList().get(i).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                        );
                    } else {
                        path.lineTo(eachX * +dataLine.getDataPointList().get(i).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                , eachY * (yMax - dataLine.getDataPointList().get(i).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                        );
                    }
                }
            } else if (dataLine.getType() == DataLine.Type.BEZIER) {
                //贝塞尔曲线图
                for (int i = 0; i < dataLine.getDataPointList().size(); i++) {
                    if (i == 0) {
                        path.moveTo(eachX * dataLine.getDataPointList().get(i).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                , eachY * (yMax - dataLine.getDataPointList().get(i).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                        );
                    } else if (i == 1) {
                        List<DataPoint> controlPointList = getBezierControlPoint(dataLine.getDataPointList().get(i - 1)
                                , dataLine.getDataPointList().get(i - 1)
                                , dataLine.getDataPointList().get(i)
                                , dataLine.getDataPointList().get(i + 1));
                        path.cubicTo(eachX * controlPointList.get(0).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                , eachY * (yMax - controlPointList.get(0).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                                , eachX * controlPointList.get(1).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                , eachY * (yMax - controlPointList.get(1).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                                , eachX * dataLine.getDataPointList().get(i).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                , eachY * (yMax - dataLine.getDataPointList().get(i).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                        );
                    } else if (i == dataLine.getDataPointList().size() - 1) {
                        List<DataPoint> controlPointList = getBezierControlPoint(dataLine.getDataPointList().get(i - 2)
                                , dataLine.getDataPointList().get(i - 1)
                                , dataLine.getDataPointList().get(i)
                                , dataLine.getDataPointList().get(i));
                        path.cubicTo(eachX * controlPointList.get(0).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                , eachY * (yMax - controlPointList.get(0).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                                , eachX * controlPointList.get(1).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                , eachY * (yMax - controlPointList.get(1).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                                , eachX * dataLine.getDataPointList().get(i).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                , eachY * (yMax - dataLine.getDataPointList().get(i).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                        );
                    } else {
                        List<DataPoint> controlPointList = getBezierControlPoint(dataLine.getDataPointList().get(i - 2)
                                , dataLine.getDataPointList().get(i - 1)
                                , dataLine.getDataPointList().get(i)
                                , dataLine.getDataPointList().get(i + 1));
                        path.cubicTo(eachX * controlPointList.get(0).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                , eachY * (yMax - controlPointList.get(0).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                                , eachX * controlPointList.get(1).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                , eachY * (yMax - controlPointList.get(1).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                                , eachX * dataLine.getDataPointList().get(i).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                , eachY * (yMax - dataLine.getDataPointList().get(i).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                        );
                    }
                }
            }
        }
        return path;
    }

    /**
     * Create By:禽兽先生
     * Create On:2018/12/23 10:42
     * Description:求两点间的三次贝塞尔的控制点,但是数据的第一个点和最后一个点没办法使用该公式
     * 解决办法是第一个点将 point1 作为 point0,最后一个点将 point2 作为 point3
     *
     * @param point0 两点左端点的上一个点
     * @param point1 两点的左端点
     * @param point2 两点的右端点
     * @param point3 两点右端点的下一个点
     */
    private List<DataPoint> getBezierControlPoint(DataPoint point0, DataPoint point1, DataPoint point2, DataPoint point3) {
        List<DataPoint> list = new ArrayList<>();
        DataPoint controlPoint1 = new DataPoint(point1.getX() + (point2.getX() - point0.getX()) * SMOOTHNESS
                , point1.getY() + (point2.getY() - point0.getY()) * SMOOTHNESS);
        DataPoint controlPoint2 = new DataPoint(point2.getX() - (point3.getX() - point1.getX()) * SMOOTHNESS
                , point2.getY() - (point3.getY() - point1.getY()) * SMOOTHNESS);
        list.add(controlPoint1);
        list.add(controlPoint2);
        return list;
    }

    /**
     * Create By:禽兽先生
     * Create On:2018/12/23 13:51
     * Description: 画水平辅助线
     */
    private void drawHorizontalLine(Canvas canvas, HorizontalLine horizontalLine) {
        mHorizontalLinePaint.setColor(horizontalLine.getColor());
        mHorizontalLinePaint.setStrokeWidth(horizontalLine.getWidth());
        mHorizontalLinePaint.setColor(horizontalLine.getColor());
        mHorizontalLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        if (horizontalLine.getDashEffect() != null) {
            mHorizontalLinePaint.setPathEffect(new DashPathEffect(new float[]{horizontalLine.getDashEffect().getLineLength(), horizontalLine.getDashEffect().getSpaceLength()}
                    , horizontalLine.getDashEffect().getPhase()));
        } else {
            mHorizontalLinePaint.setPathEffect(null);
        }

        Path path = new Path();
        path.moveTo(getPaddingLeft() + mBgPaint.getStrokeWidth(), eachY * (yMax - horizontalLine.getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop);
        path.lineTo(mWidth - getPaddingRight() - mBgPaint.getStrokeWidth(), eachY * (yMax - horizontalLine.getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop);
        canvas.drawPath(path, mHorizontalLinePaint);

        if (horizontalLine.isShowText()) {
            //画水平辅助线的文字
            Rect textBounds = new Rect();
            TextPaint textPaint = getTextPaint(horizontalLine.getTextSize()
                    , horizontalLine.getTextColor());
            //测量文字的范围
            textPaint.getTextBounds(horizontalLine.getText()
                    , 0
                    , horizontalLine.getText().length()
                    , textBounds);
            int width = textBounds.width();
            int height = textBounds.height();
            //画文字
            canvas.drawText(horizontalLine.getText()
                    , horizontalLine.getTextPosition() == HorizontalLine.TextPosition.LEFT
                            ? getPaddingLeft() + mBgPaint.getStrokeWidth() - width
                            : getPaddingLeft() + mBgPaint.getStrokeWidth()
                    , eachY * (yMax - horizontalLine.getY()) + height / 2 + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                    , textPaint);
        }
    }

    /**
     * Create By:禽兽先生
     * Create On:2018/12/23 14:01
     * Description: 获取绘制文字的画笔
     */
    private TextPaint getTextPaint(float textSize, int textColor) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(textSize);
        textPaint.setColor(textColor);
        return textPaint;
    }

    /**
     * Create By:禽兽先生
     * Create On:2018/12/24 10:08
     * Description:画横纵轴
     */
    private void drawAxis(Canvas canvas, Axis axis) {
        Rect textBounds = new Rect();
        if (axis.getType() == Axis.Type.X) {
            for (int i = axis.getOffset(); i < axis.getCount(); i += (axis.getSpace() + 1)) {
                AxisText axisText = axis.getAxisTextList().get(i);
                //将当前的轴文字对象 AxisText 回调给外部，使外部可以自定义文字、间距等
                if (axis.getAxisTextFormatter() != null) {
                    axisText = axis.getAxisTextFormatter().formatAxisText(i, axis.getAxisTextList().get(i));
                }
                //如果为空则不绘制
                if (axisText == null) {
                    continue;
                }
                //X 轴文字默认为 X 坐标
                if (TextUtils.isEmpty(axisText.getText())) {
                    axisText.setText(String.valueOf(axisText.getX()));
                }
                TextPaint textPaint = getTextPaint(axisText.getTextSize(), axisText.getTextColor());
                textPaint.setStrokeWidth(mBgStrokeWidth);
                //获取该标签文字内容的宽高
                textPaint.getTextBounds(axisText.getText(), 0, axisText.getText().length(), textBounds);
                int width = textBounds.width();
                int height = textBounds.height();
                //确定轴标签文字的 x、y 坐标
//                float x = eachX * axisText.getX() + getPaddingLeft() + mBgPaint.getStrokeWidth() - width / 2;
                float x = eachX * axisText.getX() + getPaddingLeft() + mBgPaint.getStrokeWidth() - width / 2 + axisText.getMarginLeft() - axisText.getMarginRight();
                float y = mHeight - getPaddingBottom() - mBgPaint.getStrokeWidth();
                if (axisText.getPosition() == AxisText.Position.INSIDE) {
                    y = y - axisText.getMarginBottom();
                } else {
                    y = y + height + axisText.getMarginTop();
                }
                canvas.drawText(axisText.getText()
                        , x
                        , y
                        , textPaint);
                //是否显示标签对应的刻度
                if (axisText.isShowScale()) {
                    canvas.drawLine(x + width / 2
                            , mHeight - getPaddingBottom() - mBgPaint.getStrokeWidth()
                            , x + width / 2
                            , mHeight - getPaddingBottom() - mBgPaint.getStrokeWidth() - 20
                            , textPaint);
                }
            }
        } else {
            for (int i = axis.getOffset(); i < axis.getCount(); i += (axis.getSpace() + 1)) {
                AxisText axisText = axis.getAxisTextList().get(i);
                //将当前的轴文字对象 AxisText 回调给外部，使外部可以自定义文字、间距等
                if (axis.getAxisTextFormatter() != null) {
                    axisText = axis.getAxisTextFormatter().formatAxisText(i, axis.getAxisTextList().get(i));
                }
                //如果为空则不绘制
                if (axisText == null) {
                    continue;
                }
                //Y 轴文字默认为 Y 坐标
                if (TextUtils.isEmpty(axisText.getText())) {
                    axisText.setText(String.valueOf(axisText.getY()));
                }
                TextPaint textPaint = getTextPaint(axisText.getTextSize(), axisText.getTextColor());
                textPaint.setStrokeWidth(mBgStrokeWidth);
                //获取该标签文字内容的宽高
                textPaint.getTextBounds(axisText.getText(), 0, axisText.getText().length(), textBounds);
                int width = textBounds.width();
                int height = textBounds.height();
                //确定轴标签文字的 x、y 坐标
                float x = getPaddingLeft() + mBgPaint.getStrokeWidth();
                float y = eachY * (yMax - axisText.getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop + height / 2;
                if (axisText.getPosition() == AxisText.Position.INSIDE) {
                    x = x + axisText.getMarginLeft();
                } else {
                    x = x - width - axisText.getMarginRight();
                }
                canvas.drawText(axisText.getText()
                        , x
                        , y
                        , textPaint);
                //是否显示标签对应的刻度
                if (axisText.isShowScale()) {
                    canvas.drawLine(getPaddingLeft() + mBgPaint.getStrokeWidth()
                            , y - height / 2
                            , getPaddingLeft() + mBgPaint.getStrokeWidth() + 20
                            , y - height / 2
                            , textPaint);
                }
            }
        }
    }

    /**
     * Create By:禽兽先生
     * Create On:2018/12/24 14:24
     * Description:画高亮点
     */
    private void drawHighlightPoint(Canvas canvas, HighlightDataPoint highlightDataPoint) {
        mHighlightDataPointPaint.setColor(highlightDataPoint.getColor());
        canvas.drawCircle(eachX * highlightDataPoint.getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                , eachY * (yMax - highlightDataPoint.getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                , highlightDataPoint.getRadius()
                , mHighlightDataPointPaint
        );
    }

    /**
     * Create By:禽兽先生
     * Create On:2018/12/24 15:31
     * Description:画触摸位置
     */
    private void drawTouchPosition(Canvas canvas) {
        mTouchLinePaint.setColor(mTouchLineColor);
        mTouchLinePaint.setStrokeWidth(mTouchLineWidth);
        if (mShowTouchLineY) {
            //纵轴线
            mTouchLinePaint.setColor(Color.parseColor("#FF000000"));
            mTouchLinePaint.setStrokeWidth(1f);
            canvas.drawLine(eachX * touchPosition + getPaddingLeft() + mBgPaint.getStrokeWidth()
                    , getPaddingTop()
                    , eachX * touchPosition + getPaddingLeft() + mBgPaint.getStrokeWidth()
                    , mHeight - getPaddingBottom()
                    , mTouchLinePaint
            );
        }
        Rect textBounds = new Rect();
        for (DataLine dataLine : mDataLineList) {
            if (dataLine == null || dataLine.getDataPointList().isEmpty()) {
                continue;
            }
            if (mShowTouchLineX) {
                //横轴线
                mTouchLinePaint.setColor(Color.parseColor("#FF000000"));
                mTouchLinePaint.setStrokeWidth(1f);
                canvas.drawLine(getPaddingLeft()
                        , eachY * (yMax - dataLine.getDataPointList().get(touchPosition).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                        , mWidth - getPaddingRight()
                        , eachY * (yMax - dataLine.getDataPointList().get(touchPosition).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                        , mTouchLinePaint
                );
            }
            if (mShowTouchLinePoint) {
                //触摸点最近的数据点
                mTouchLinePaint.setColor(dataLine.getColor());
                mTouchLinePaint.setStrokeWidth(4f);
                canvas.drawCircle(eachX * touchPosition + getPaddingLeft() + mBgPaint.getStrokeWidth()
                        , eachY * (yMax - dataLine.getDataPointList().get(touchPosition).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                        , mTouchLinePaint.getStrokeWidth() * 2
                        , mTouchLinePaint
                );
                if (mShowTouchLinePointText) {
                    //绘制数据点的值
                    String text = String.valueOf(dataLine.getDataPointList().get(touchPosition).getY());
                    TextPaint textPaint = getTextPaint(mTouchLineTextSize, mTouchLineTextColor);
                    textPaint.getTextBounds(text, 0, text.length(), textBounds);
                    canvas.drawText(text
                            , eachX * touchPosition + getPaddingLeft() + mBgPaint.getStrokeWidth() + 15
                            , eachY * (yMax - dataLine.getDataPointList().get(touchPosition).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop - 15
                            , textPaint);
                }
            }

        }
    }


    /**
     * Create By:禽兽先生
     * Create On:2018/12/23 14:01
     * Description: 开始绘制
     */
    public void draw() {
        if (mAnimateDraw) {
            animateDraw();
        } else {
            postInvalidate();
        }
    }

    private void animateDraw() {
        //延时执行，保证 eachX 和 eachY 设置了值
        this.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < mDataLineList.size(); i++) {
                    final DataLine dataLine = mDataLineList.get(i);
                    if (dataLine.getDataPointList().isEmpty()) {
                        continue;
                    }
                    final Path path = getDataLinePath(dataLine);
                    final PathMeasure pathMeasure = new PathMeasure(path, false);
                    ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
                    valueAnimator.setDuration(2000);
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            //先从容器中取动态绘制的 Path，如果没有再创建并存到容器中
                            Path dataLineAnimatePath = mDataLineAnimatePathSparseArray.get(dataLine.hashCode());
                            if (dataLineAnimatePath == null) {
                                dataLineAnimatePath = new Path();
                                mDataLineAnimatePathSparseArray.put(dataLine.hashCode(), dataLineAnimatePath);
                            }
                            float value = (float) animation.getAnimatedValue();
                            //每次重置一下 dataLineAnimatePath，如果不重置，drawDataLine() 方法中拿到 dataLineAnimatePath 的长度不会变化
                            //导致绘制填充部分有问题
                            dataLineAnimatePath.reset();
                            dataLineAnimatePath.moveTo(eachX * dataLine.getDataPointList().get(0).getX() + getPaddingLeft() + mBgPaint.getStrokeWidth()
                                    , eachY * (yMax - dataLine.getDataPointList().get(0).getY()) + getPaddingTop() + mBgPaint.getStrokeWidth() + chartPaddingTop
                            );
                            boolean success = pathMeasure.getSegment(0, pathMeasure.getLength() * value, dataLineAnimatePath, true);
                            //拷贝的 dataLineAnimatePath 的长度不为 0 才去绘制
                            if (success) {
                                invalidate();
                            }
                        }
                    });
                    valueAnimator.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                            mAnimateDrawing = true;
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            mAnimateDrawing = false;
                        }
                    });
                    valueAnimator.start();
                }
            }
        });
    }

    /**
     * Create By:禽兽先生
     * Create On:2018/12/25 14:00
     * Description: 根据最大个数确定横轴每一单元的长度，根据最大值最小值确定纵轴每一单元的长度
     */
    private void setEachX(final int size) {
        //因为此时可能 ChartView 还没有调用构造方法，所以延时一下确保能获取到宽高
        this.post(new Runnable() {
            @Override
            public void run() {
                eachX = (float) (mWidth - getPaddingLeft() - getPaddingRight() - mBgPaint.getStrokeWidth() * 2)
                        / (float) (size - 1);
            }
        });
        mAxisX = mAxisMap.get(Axis.Type.X);
        if (mAxisX == null) {
            mAxisX = new Axis(Axis.Type.X);
            mAxisMap.put(Axis.Type.X, mAxisX);
        }
        mAxisX.clearAxisTextList();
        for (int i = 0; i < size; i++) {
            mAxisX.addText(new AxisText(i, yMin));
        }
    }

    private void setEachY() {
        //因为此时可能 ChartView 还没有调用构造方法，所以延时一下确保能获取到宽高
        this.post(new Runnable() {
            @Override
            public void run() {
                eachY = (float) (mHeight - getPaddingTop() - getPaddingBottom() - mBgPaint.getStrokeWidth() * 2 - chartPaddingTop - chartPaddingBottom)
                        / (float) (yMax - yMin);
            }
        });
        mAxisY = mAxisMap.get(Axis.Type.Y);
        if (mAxisY == null) {
            mAxisY = new Axis(Axis.Type.Y);
            mAxisMap.put(Axis.Type.Y, mAxisY);
        }
        mAxisY.clearAxisTextList();
        for (int i = (int) yMin; i <= yMax; i++) {
            mAxisY.addText(new AxisText(0, i));
        }
    }

    public float getEachY() {
        return eachY;
    }

    public int getBgColor() {
        return mBgColor;
    }

    public void setBgColor(int bgColor) {
        this.mBgColor = bgColor;
    }

    public int getBgStrokeWidth() {
        return mBgStrokeWidth;
    }

    public void setBgStrokeWidth(int bgStrokeWidth) {
        mBgStrokeWidth = bgStrokeWidth;
    }

    public int getBgStrokeColor() {
        return mBgStrokeColor;
    }

    public void setBgStrokeColor(int bgStrokeColor) {
        this.mBgStrokeColor = bgStrokeColor;
    }

    public float getBgStrokeRadius() {
        return mBgStrokeRadius;
    }

    public void setBgStrokeRadius(float bgStrokeRadius) {
        this.mBgStrokeRadius = bgStrokeRadius;
    }

    public float getYMax() {
        return yMax;
    }

    public void setYMax(final float yMax) {
        this.yMax = yMax;
        setEachY();
    }

    public void setYMin(final float yMin) {
        this.yMin = yMin;
        setEachY();
    }

    public float getYMin() {
        return yMin;
    }

    public float getChartPaddingTop() {
        return chartPaddingTop;
    }

    public void setChartPaddingTop(float chartPaddingTop) {
        this.chartPaddingTop = chartPaddingTop;
    }

    public float getChartPaddingBottom() {
        return chartPaddingBottom;
    }

    public void setChartPaddingBottom(float chartPaddingBottom) {
        this.chartPaddingBottom = chartPaddingBottom;
    }

    public Axis getAxisX() {
        return mAxisX;
    }

    public Axis getAxisY() {
        return mAxisY;
    }

    /**
     * Create By:禽兽先生
     * Create On:2018/12/23 11:04
     * Description: 添加数据线
     */
    public void addDataLine(DataLine dataLine) {
        mDataLineList.add(dataLine);
        int size = 0;
        //找到每条数据线的个数、最大值中的最大值，每条数据线最小值中的最小值
        for (DataLine d : mDataLineList) {
            if (d.getSize() > size) {
                size = d.getSize();
            }
            if (d.getMax() > yMax) {
                yMax = d.getMax();
            }
            if (d.getMin() < yMin) {
                yMin = d.getMin();
            }
        }
        setEachX(size);
        setYMax(yMax);
        setYMin(yMin);
    }

    /**
     * Create By:禽兽先生
     * Create On:2018/12/23 11:04
     * Description: 添加水平辅助线
     */
    public void addHorizontalLine(HorizontalLine horizontalLine) {
        mHorizontalLineList.add(horizontalLine);
    }

    /**
     * Create By:禽兽先生
     * Create On:2018/12/24 14:56
     * Description: 添加高亮数据点
     */
    public void addHighlightDataPoint(HighlightDataPoint highlightDataPoint) {
        mHighlightDataPointList.add(highlightDataPoint);
    }

    public void setShowTouchLineX(boolean showTouchLineX) {
        this.mShowTouchLineX = showTouchLineX;
    }

    public void setShowTouchLineY(boolean showTouchLineY) {
        this.mShowTouchLineY = showTouchLineY;
    }

    public void setTouchLineWidth(float touchLineWidth) {
        this.mTouchLineWidth = touchLineWidth;
    }

    public void setTouchLineColor(int touchLineColor) {
        this.mTouchLineColor = touchLineColor;
    }

    public void setTouchLineTextSize(int touchLineTextSize) {
        this.mTouchLineTextSize = touchLineTextSize;
    }

    public void setTouchLineTextColor(int touchLineTextColor) {
        this.mTouchLineTextColor = touchLineTextColor;
    }

    public void setShowTouchLinePoint(boolean showTouchLinePoint) {
        this.mShowTouchLinePoint = showTouchLinePoint;
    }

    public void setShowTouchLinePointText(boolean showTouchLinePointText) {
        mShowTouchLinePointText = showTouchLinePointText;
    }

    public void setOnDataPointSelectedListener(IOnDataPointSelectedListener onDataPointSelectedListener) {
        mOnDataPointSelectedListener = onDataPointSelectedListener;
    }

    public void setAnimateDraw(boolean animateDraw) {
        this.mAnimateDraw = animateDraw;
    }

    public void reset() {
        mDataLineList.clear();
        mHorizontalLineList.clear();
        mHighlightDataPointList.clear();
        if (mAxisX != null) {
            mAxisX.clearAxisTextList();
        }
        if (mAxisY != null) {
            mAxisY.clearAxisTextList();
        }
    }
}
