package com.qinshou.commonmodule.widget.chartview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.qinshou.commonmodule.util.DisplayUtil;
import com.qinshou.commonmodule.widget.chartview.component.Axis;
import com.qinshou.commonmodule.widget.chartview.component.HighlightPoint;
import com.qinshou.commonmodule.widget.chartview.component.HorizontalLine;
import com.qinshou.commonmodule.widget.chartview.component.Label;
import com.qinshou.commonmodule.widget.chartview.component.Point;
import com.qinshou.commonmodule.widget.chartview.listener.IOnValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:ChartView 的基类
 * Created by 禽兽先生
 * Created on 2018/3/15
 */

public class BaseChartView extends View {
    private static final float SMOOTHNESS = 0.25f;

    private int chartWidth; //图表的宽度
    private int chartHeight;    //图表的高度
    private int padding;    //图表在控件中的内边距

    private RectF roundRectF;   //图表的边框
    private Paint roundRectFPaint;   //图表边框的画笔
    private float roundRectFRadius; //图表边框四个圆角的圆滑度

    private float eachX;    //横轴每一单元的长度
    private float eachY;    //纵轴每一单元的长度
    private boolean touching;   //是否正在触摸的标志位
    private int touchPosition;  //离触摸点最近的数据点的位置
    private Paint touchLinePaint;   //触摸时出现的线的画笔

    private Paint axisLabelPaint;   //轴标签的画笔
    private Rect textBounds;   //测量文字宽高的矩形

    private Axis xAxis; //X 轴
    private Axis yAxis; //Y 轴

    private int strokeColor;    //圆角矩形框颜色
    private int backgroundColor;    //背景填充颜色

    private IOnValueSelectedListener onValueSelectedListener;   //触摸时回调监听器

    private float max;  //纵轴最大值
    private float min;  //纵轴最小值

    private List<HorizontalLine> horizontalLineList;    //水平辅助线的集合
    private List<HighlightPoint> highlightPointList;    //高亮点的集合
    private boolean showTouchLine = true;   //默认显示触摸线
    private List<Path> fillPathList = new ArrayList<>();    //填充的路径的集合
    private Paint fillPathPaint;    //填充的路径的画笔


    public BaseChartView(Context context) {
        this(context, null);
    }

    public BaseChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint(context);

        padding = DisplayUtil.dp2px(context, 15f);
        roundRectF = new RectF();
        roundRectFRadius = DisplayUtil.dp2px(context, 2f);

        textBounds = new Rect();

        xAxis = new Axis();
        yAxis = new Axis();
    }

    private void initPaint(Context context) {
        roundRectFPaint = new Paint();
        roundRectFPaint.setAntiAlias(true);
        roundRectFPaint.setStrokeWidth(DisplayUtil.dp2px(context, 1f));

        touchLinePaint = new Paint();
        touchLinePaint.setAntiAlias(true);
        touchLinePaint.setStrokeWidth(DisplayUtil.dp2px(context, 1f));
        setTouchLinePaintColor(Color.rgb(222, 235, 255));

        axisLabelPaint = new Paint();
        axisLabelPaint.setAntiAlias(true);
        axisLabelPaint.setTextSize(DisplayUtil.sp2px(context, 10f));
        axisLabelPaint.setColor(Color.rgb(51, 51, 51));

        fillPathPaint = new Paint();
        fillPathPaint.setAntiAlias(true);
        fillPathPaint.setStrokeWidth(1f);
        fillPathPaint.setStyle(Paint.Style.FILL);
        fillPathPaint.setColor(Color.parseColor("#33333333"));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = getContext().getResources().getDisplayMetrics().widthPixels;
        }

        int height;
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = getContext().getResources().getDisplayMetrics().heightPixels / 2;
        }
        chartWidth = width - padding * 2;
        chartHeight = height - padding * 2;
        //当未指定具体宽高时,宽为屏幕宽,高为屏幕高的一半
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            setLayerType(LAYER_TYPE_SOFTWARE, null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < padding
                        || event.getX() > chartWidth + padding
                        || event.getY() < padding
                        || event.getY() > chartHeight + padding
                        || eachX == 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
                //使父布局不拦截触摸事件
                getParent().requestDisallowInterceptTouchEvent(true);
                touching = true;
                touchPosition = (int) ((event.getX() - padding) / eachX);
                if (((event.getX() - padding) % eachX) > eachX / 2) {
                    touchPosition++;
                }
                if (onValueSelectedListener != null) {
                    onValueSelectedListener.onValueSelected(event.getRawX(), event.getRawY(), touchPosition);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getX() < padding
                        || event.getX() > chartWidth + padding
                        || event.getY() < padding
                        || event.getY() > chartHeight + padding
                        || eachX == 0) {
                    touching = false;
                    touchPosition = -1;
                    invalidate();
                    return false;
                }
                //使父布局不拦截触摸事件
                getParent().requestDisallowInterceptTouchEvent(true);
                touching = true;
                touchPosition = (int) ((event.getX() - padding) / eachX);
                if (((event.getX() - padding) % eachX) > eachX / 2) {
                    touchPosition++;
                }
                if (onValueSelectedListener != null) {
                    onValueSelectedListener.onValueSelected(event.getRawX(), event.getRawY(), touchPosition);
                }
                break;
            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(false);
                touching = false;
                touchPosition = -1;
                if (onValueSelectedListener != null) {
                    onValueSelectedListener.onValueCancelSelected();
                }
                break;
        }
        invalidate();
        return true;
    }

    /**
     * Description:画背景
     * Date:2018/3/20
     */
    protected void drawBackground(Canvas canvas) {
        //设置圆角矩形的宽高
        roundRectF.set(padding + roundRectFPaint.getStrokeWidth()
                , padding + roundRectFPaint.getStrokeWidth()
                , chartWidth + padding - roundRectFPaint.getStrokeWidth()
                , chartHeight + padding - roundRectFPaint.getStrokeWidth());
        //画背景
        roundRectFPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        roundRectFPaint.setColor(backgroundColor);
        canvas.drawRoundRect(roundRectF, roundRectFRadius, roundRectFRadius, roundRectFPaint);
    }

    /**
     * Description:画边框
     * Date:2018/3/20
     */
    protected void drawStroke(Canvas canvas) {
        //设置圆角矩形的宽高
        roundRectF.set(padding, padding, chartWidth + padding, chartHeight + padding);
        //画圆角矩形
        roundRectFPaint.setStyle(Paint.Style.STROKE);
        roundRectFPaint.setColor(strokeColor);
        canvas.drawRoundRect(roundRectF, roundRectFRadius, roundRectFRadius, roundRectFPaint);
    }

    /**
     * Description:画触摸位置
     * Date:2018/3/20
     */
    protected void drawTouchPosition(Canvas canvas) {
        if (showTouchLine && touching && touchPosition > -1) {
            canvas.drawLine(eachX * touchPosition + padding, padding, eachX * touchPosition + padding, chartHeight + padding, touchLinePaint);
        }
    }

    /**
     * Description:画横纵轴标签
     * Date:2018/3/20
     */
    protected void drawAxisLabel(Canvas canvas) {
        if (xAxis.getLabelList() != null && !xAxis.getLabelList().isEmpty()) {
            for (int i = xAxis.getOffset(); i < xAxis.getCount(); i += (xAxis.getSpace() + 1)) {
                Label mLabel = xAxis.getLabelList().get(i);
                axisLabelPaint.setColor(mLabel.getColor());
                //获取该标签文字内容的宽高
                axisLabelPaint.getTextBounds(mLabel.getLabel(), 0, mLabel.getLabel().length(), textBounds);
                int labelWidth = textBounds.width();
                int labelHeight = textBounds.height();
                //根据标签显示在轴内部还是外部来决定标签的坐标
                float x;
                if (xAxis.getLabelList().size() == 1) {
                    x = padding - labelWidth / 2;
                } else {
                    x = i * chartWidth / (xAxis.getLabelList().size() - 1) + padding - labelWidth / 2;
                }
                float y = xAxis.getLabelPosition() == Axis.LabelPosition.INSIDE
                        ? chartHeight + padding - mLabel.getMarginBottom()
                        : chartHeight + padding + labelHeight + mLabel.getMarginTop();
                canvas.drawText(mLabel.getLabel(), x, y, axisLabelPaint);
                //是否显示标签对应的刻度
                if (xAxis.isShowScale()) {
                    canvas.drawLine(x + labelWidth / 2
                            , chartHeight + padding - 20
                            , x + labelWidth / 2
                            , chartHeight + padding
                            , roundRectFPaint);
                }
            }
        }
        if (yAxis.getLabelList() != null && !yAxis.getLabelList().isEmpty()) {
            for (int i = yAxis.getOffset(); i < yAxis.getCount(); i += (yAxis.getSpace() + 1)) {
                Label mLabel = yAxis.getLabelList().get(i);
                axisLabelPaint.setColor(mLabel.getColor());
                axisLabelPaint.getTextBounds(mLabel.getLabel(), 0, mLabel.getLabel().length(), textBounds);
                int labelWidth = textBounds.width();
                int labelHeight = textBounds.height();
                float x = yAxis.getLabelPosition() == Axis.LabelPosition.INSIDE
                        ? padding + mLabel.getMarginLeft()
                        : padding - labelWidth - mLabel.getMarginRight();
                float y = i * chartHeight / (yAxis.getLabelList().size() - 1) + padding + labelHeight / 2;
                canvas.drawText(mLabel.getLabel(), x, y, axisLabelPaint);
            }
        }
    }

    /**
     * Description:画水平辅助线
     * Date:2018/3/20
     */
    protected void drawHorizontalLine(Canvas canvas, HorizontalLine horizontalLine) {
        Path mPath = new Path();
        pathMoveTo(mPath, 0, (max - horizontalLine.getY()) * eachY);
        pathLineTo(mPath, chartWidth, (max - horizontalLine.getY()) * eachY);
        canvas.drawPath(mPath, getHorizontalLinePaint(horizontalLine));
        if (horizontalLine.isShowValue()) {
            Paint mPaint = getHorizontalLineValuePaint(horizontalLine);
            mPaint.getTextBounds(String.valueOf(horizontalLine.getY()), 0, String.valueOf(horizontalLine.getY()).length(), textBounds);
            int width = textBounds.width();
            int height = textBounds.height();
            canvas.drawText(String.valueOf(horizontalLine.getY()), padding, (max - horizontalLine.getY()) * eachY + padding + height / 2, mPaint);
        }
    }

    /**
     * Description:画高亮点
     * Date:2018/4/3
     */
    protected void drawHighlightPoint(Canvas canvas) {
        for (int i = 0; highlightPointList != null && i < highlightPointList.size(); i++) {
            HighlightPoint mHighlightPoint = highlightPointList.get(i);
            canvas.drawPoint(eachX * mHighlightPoint.getX() + padding, eachY * (max - mHighlightPoint.getY()) + padding, getHighlightPointPaint(mHighlightPoint));
        }
    }

    /**
     * Description:返回一个画水平辅助线的画笔
     * Date:2018/3/20
     */
    private Paint getHorizontalLinePaint(HorizontalLine horizontalLine) {
        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(DisplayUtil.dp2px(getContext(), 1f));
        mPaint.setColor(horizontalLine.getColor());
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        if (horizontalLine.getDashEffect() != null) {
            mPaint.setPathEffect(new DashPathEffect(new float[]{horizontalLine.getDashEffect().getLineLength(), horizontalLine.getDashEffect().getSpaceLength()}
                    , horizontalLine.getDashEffect().getPhase()));
        } else {
            mPaint.setPathEffect(null);
        }
        return mPaint;
    }

    private Paint getHorizontalLineValuePaint(HorizontalLine horizontalLine) {
        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(horizontalLine.getValueTextSize());
        mPaint.setColor(horizontalLine.getValueTextColor());
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        return mPaint;
    }

    private Paint getHighlightPointPaint(HighlightPoint mHighlightPoint) {
        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(mHighlightPoint.getRadius());
        mPaint.setColor(mHighlightPoint.getColor());
        return mPaint;
    }

    protected void pathMoveTo(Path path, float x, float y) {
        path.moveTo(x + padding, y + padding);
    }

    protected void pathLineTo(Path path, float x, float y) {
        path.lineTo(x + padding, y + padding);
    }

    protected void pathCubicTo(Path path, float x1, float y1, float x2, float y2, float x3, float y3) {
        path.cubicTo(x1 + padding, y1 + padding
                , x2 + padding, y2 + padding
                , x3 + padding, y3 + padding);
    }

    /**
     * Description:求两点间的三次贝塞尔的控制点,但是数据的第一个点和最后一个点没办法使用该公式
     * 解决办法是第一个点将 point1 作为 point0,最后一个点将 point2 作为 point3
     * <p>
     * Date:2018/3/13
     *
     * @param point0 两点左端点的上一个点
     * @param point1 两点的左端点
     * @param point2 两点的右端点
     * @param point3 两点右端点的下一个点
     */
    protected List<Point> getBezierControlPoint(Point point0, Point point1, Point point2, Point point3) {
        List<Point> controlPointList = new ArrayList<>();
        Point controlPoint1 = new Point(point1.getX() + (point2.getX() - point0.getX()) * SMOOTHNESS
                , point1.getY() + (point2.getY() - point0.getY()) * SMOOTHNESS);
        Point controlPoint2 = new Point(point2.getX() - (point3.getX() - point1.getX()) * SMOOTHNESS
                , point2.getY() - (point3.getY() - point1.getY()) * SMOOTHNESS);
        controlPointList.add(controlPoint1);
        controlPointList.add(controlPoint2);
        return controlPointList;
    }

    protected int getPadding() {
        return padding;
    }

    protected int getChartWidth() {
        return chartWidth;
    }

    protected int getChartHeight() {
        return chartHeight;
    }

    public float getEachX() {
        return eachX;
    }

    protected void setEachX(float eachX) {
        this.eachX = eachX;
    }

    public float getEachY() {
        return eachY;
    }

    protected void setEachY(float eachY) {
        this.eachY = eachY;
    }

    protected int getTouchPosition() {
        return touchPosition;
    }

    protected void setTouchLinePaintColor(int color) {
        touchLinePaint.setColor(color);
    }

    public float getMax() {
        return max;
    }

    /**
     * Description:设置纵轴最大值，该方法需在 setLine() 或 setLineList() 方法之后调用，不然 setLine() 和 setLineList() 会覆盖最大最小值
     * Date:2018/11/23
     */
    protected void setMax(float max) {
        this.max = max;
    }

    /**
     * Description:设置纵轴最小值，该方法需在 setLine() 或 setLineList() 方法之后调用，不然 setLine() 和 setLineList() 会覆盖最大最小值
     * Date:2018/11/23
     */
    public float getMin() {
        return min;
    }

    protected void setMin(float min) {
        this.min = min;
    }

    protected boolean isTouching() {
        return touching;
    }

    public void setOnValueSelectedListener(IOnValueSelectedListener onValueSelectedListener) {
        this.onValueSelectedListener = onValueSelectedListener;
    }

    public Axis getXAxis() {
        return xAxis;
    }

    public Axis getYAxis() {
        return yAxis;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void addHorizontalLine(HorizontalLine horizontalLine) {
        if (horizontalLineList == null) {
            horizontalLineList = new ArrayList<>();
        }
        horizontalLineList.add(horizontalLine);
    }

    public List<HorizontalLine> getHorizontalLineList() {
        return horizontalLineList;
    }

    public void setHorizontalLineList(List<HorizontalLine> horizontalLineList) {
        this.horizontalLineList = horizontalLineList;
    }

    public void setTouchLineColor(int color) {
        touchLinePaint.setColor(color);
    }

    public int getTouchLineColor() {
        return touchLinePaint.getColor();
    }

    public boolean isShowTouchLine() {
        return showTouchLine;
    }

    public void setShowTouchLine(boolean showTouchLine) {
        this.showTouchLine = showTouchLine;
    }

    public void addHighlightPoint(HighlightPoint highlightPoint) {
        if (highlightPointList == null) {
            highlightPointList = new ArrayList<>();
        }
        highlightPointList.add(highlightPoint);
    }

    public void drawFillPath(Canvas canvas, List<Point> pointList) {
        canvas.drawPath(getFillPath(pointList), fillPathPaint);
    }

    public Path getFillPath(List<Point> pointList) {
        Path path = new Path();
        for (int i = 0; i < pointList.size(); i++) {
            if (i == 0) {
                pathMoveTo(path, getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            } else {
                pathLineTo(path, getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            }
        }
        pathLineTo(path, getChartWidth(), getChartHeight());
        pathLineTo(path, 0, getChartHeight());
        pathLineTo(path, getEachX() * pointList.get(0).getX(), getEachY() * (getMax() - pointList.get(0).getY()));
        return path;
    }

    public void draw() {
        invalidate();
    }
}
