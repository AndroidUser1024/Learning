package com.qinshou.commonmodule.widget.chartview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;

import com.qinshou.commonmodule.widget.chartview.component.HorizontalLine;
import com.qinshou.commonmodule.widget.chartview.component.Line;
import com.qinshou.commonmodule.widget.chartview.component.Point;

import java.util.List;


/**
 * Description:单条线的折线图,支持普通折线,平滑曲线,以及普通折线及填充,平滑曲线及填充
 * 普通折线,平滑曲线支持动态绘制,带填充的线暂不支持动态绘制
 * Created by 禽兽先生
 * Created on 2018/3/15
 */

public class SingleLineChartView extends BaseChartView {
    private Line line;

    private Path dataLinePath;  //数据线的路径
    private Paint dataLinePaint;    //数据线的画笔

    private Path dataLineFillPath;  //数据线填充部分的路径
    private Paint dataLineFillPaint;    //数据线填充部分的画笔
    private boolean isAnimateDraw = false;

    private Paint touchPointPaint;
    private boolean showTouchPoint = true;

    public SingleLineChartView(Context context) {
        this(context, null);
    }

    public SingleLineChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SingleLineChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint(context);
        dataLinePath = new Path();
        dataLineFillPath = new Path();
    }

    private void initPaint(Context context) {
        dataLinePaint = new Paint();
        dataLinePaint.setAntiAlias(true);
        dataLinePaint.setStyle(Paint.Style.STROKE);
        dataLinePaint.setStrokeCap(Paint.Cap.ROUND);

        dataLineFillPaint = new Paint();
        dataLineFillPaint.setAntiAlias(true);
        dataLineFillPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        dataLineFillPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackground(canvas);
        drawStroke(canvas);
        for (int i = 0; getHorizontalLineList() != null && i < getHorizontalLineList().size(); i++) {
            HorizontalLine mHorizontalLine = getHorizontalLineList().get(i);
            if (mHorizontalLine.getLevel() == HorizontalLine.Level.BELOW) {
                drawHorizontalLine(canvas, mHorizontalLine);
            }
        }
        drawAxisLabel(canvas);

        if (line == null) {
            return;
        }
        dataLinePaint.setStrokeWidth(line.getWidth());
        dataLinePaint.setColor(line.getColor());
        canvas.drawPath(dataLinePath, dataLinePaint);

        dataLineFillPaint.setStrokeWidth(1f);
        dataLineFillPaint.setColor(line.getFillColor());
        canvas.drawPath(dataLineFillPath, dataLineFillPaint);

        for (int i = 0; getHorizontalLineList() != null && i < getHorizontalLineList().size(); i++) {
            HorizontalLine mHorizontalLine = getHorizontalLineList().get(i);
            if (mHorizontalLine.getLevel() == HorizontalLine.Level.ABOVE) {
                drawHorizontalLine(canvas, mHorizontalLine);
            }
        }
        drawHighlightPoint(canvas);

        drawTouchPosition(canvas);
    }

    @Override
    protected void drawTouchPosition(Canvas canvas) {
        super.drawTouchPosition(canvas);
        if (showTouchPoint && isTouching() && getTouchPosition() > -1) {
            canvas.drawPoint(getEachX() * getTouchPosition() + getPadding()
                    , getEachY() * (getMax() - line.getPointList().get(getTouchPosition()).getY()) + getPadding()
                    , getTouchPointPaint());
        }
    }

    private Paint getTouchPointPaint() {
        if (touchPointPaint == null) {
            touchPointPaint = new Paint();
        }
        touchPointPaint.setStrokeWidth(dataLinePaint.getStrokeWidth() * 2);
        touchPointPaint.setStrokeCap(Paint.Cap.ROUND);
        return touchPointPaint;
    }

    /**
     * Description:将每个数据集合初始化成普通折线的 Path
     * Date:2018/3/13
     */
    private void initLinearPath(List<Point> pointList) {
        dataLinePath.reset();
        for (int i = 0; i < pointList.size(); i++) {
            if (i == 0) {
                pathMoveTo(dataLinePath, getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            } else {
                pathLineTo(dataLinePath, getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            }
        }
    }

    private void initBezierPath(List<Point> pointList) {
        dataLinePath.reset();
        for (int i = 0; i < pointList.size(); i++) {
            if (i == 0) {
                pathMoveTo(dataLinePath, getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            } else if (i == 1) {
                List<Point> controlPointList = getBezierControlPoint(pointList.get(i - 1), pointList.get(i - 1), pointList.get(i), pointList.get(i + 1));
                pathCubicTo(dataLinePath, getEachX() * controlPointList.get(0).getX(), getEachY() * (getMax() - controlPointList.get(0).getY())
                        , getEachX() * controlPointList.get(1).getX(), getEachY() * (getMax() - controlPointList.get(1).getY())
                        , getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            } else if (i == pointList.size() - 1) {
                List<Point> controlPointList = getBezierControlPoint(pointList.get(i - 2), pointList.get(i - 1), pointList.get(i), pointList.get(i));
                pathCubicTo(dataLinePath, getEachX() * controlPointList.get(0).getX(), getEachY() * (getMax() - controlPointList.get(0).getY())
                        , getEachX() * controlPointList.get(1).getX(), getEachY() * (getMax() - controlPointList.get(1).getY())
                        , getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            } else {
                List<Point> controlPointList = getBezierControlPoint(pointList.get(i - 2), pointList.get(i - 1), pointList.get(i), pointList.get(i + 1));
                pathCubicTo(dataLinePath, getEachX() * controlPointList.get(0).getX(), getEachY() * (getMax() - controlPointList.get(0).getY())
                        , getEachX() * controlPointList.get(1).getX(), getEachY() * (getMax() - controlPointList.get(1).getY())
                        , getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            }
        }
    }

    /**
     * Description:该方法必须在 initLinearPath() 或 initBezierPath() 方法之后调用
     * Date:2018/3/15
     */
    private void initFillPath(List<Point> pointList) {
        dataLineFillPath.reset();
        for (int i = 0; i < pointList.size(); i++) {
            if (i == 0) {
                pathMoveTo(dataLineFillPath, getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            } else {
                pathLineTo(dataLineFillPath, getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            }
        }
        pathLineTo(dataLineFillPath, getChartWidth(), getChartHeight());
        pathLineTo(dataLineFillPath, 0, getChartHeight());
        pathLineTo(dataLineFillPath, getEachX() * pointList.get(0).getX(), getEachY() * (getMax() - pointList.get(0).getY()));
    }

    private void initDataPath() {
        switch (line.getMode()) {
            case LINEAR:
                initLinearPath(line.getPointList());
                break;
            case BEZIER:
                initBezierPath(line.getPointList());
                break;
            case LINEAR_AND_FILL:
                initLinearPath(line.getPointList());
                initFillPath(line.getPointList());
                break;
            case BEZIER_AND_FILL:
                initBezierPath(line.getPointList());
                initFillPath(line.getPointList());
                break;
        }
    }

    private void animateDraw() {
        if (!isAnimateDraw) {
            return;
        }
        final PathMeasure mPathMeasure = new PathMeasure();
        mPathMeasure.setPath(dataLinePath, false);
        dataLinePath.reset();
        ValueAnimator mValueAnimator = ValueAnimator.ofFloat(0f, 1f);
        mValueAnimator.setDuration(1000);
        mValueAnimator.setInterpolator(new LinearInterpolator());
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mPathMeasure.getSegment(0, mPathMeasure.getLength() * value, dataLinePath, true);
                invalidate();
            }
        });
        mValueAnimator.start();
    }

    private void refresh() {
        post(new Runnable() {
            @Override
            public void run() {
                if (line == null) {
                    return;
                }
                setEachX((float) getChartWidth() / (float) (line.getSize() - 1));
                setEachY((float) getChartHeight() / (getMax() - getMin()));
                initDataPath();
                animateDraw();
                invalidate();
            }
        });
    }

    @Override
    public void setMax(float max) {
        super.setMax(max);
        refresh();
    }

    @Override
    public void setMin(float min) {
        super.setMin(min);
        refresh();
    }

    public boolean isAnimateDraw() {
        return isAnimateDraw;
    }

    public void setAnimateDraw(boolean animateDraw) {
        isAnimateDraw = animateDraw;
        refresh();
    }

    public void setLine(Line pLine) {
        this.line = pLine;
        super.setMax(line.getMax());
        super.setMin(line.getMin());
        refresh();
    }

    public void setTouchPointColor(int color) {
        getTouchPointPaint().setColor(color);
    }

    public int getTouchPointColor() {
        return getTouchPointPaint().getColor();
    }

    public boolean isShowTouchPoint() {
        return showTouchPoint;
    }

    public void setShowTouchPoint(boolean showTouchPoint) {
        this.showTouchPoint = showTouchPoint;
    }

    public void setMax(float max, float paddingMax, float paddingMin) {
        //计算减掉上下距离后的每一单元的高度
        float f1 = (getChartHeight() - paddingMax - paddingMin) / (getMax() - getMin());
        //先计算原本高度与 f1 的商,即为按照减掉上下距离后的每一单元的高度计算出来的所需要的最大最小值的差,再减去原本最大最小值的差
        //得到所需要的最大最小值的差与实际最大最小值的差 的差f2
        float f2 = getChartHeight() / f1 - (getMax() - getMin());
        float f3 = f2 / 2;
        //重新计算最大值
        setMax(max + f3);
    }

    public void setMin(float min, float paddingMax, float paddingMin) {
        float f1 = (getChartHeight() - paddingMax - paddingMin) / (getMax() - getMin());
        float f2 = getChartHeight() / f1 - (getMax() - getMin());
        float f3 = f2 / 2;
        setMin(min - f3);
    }
}
