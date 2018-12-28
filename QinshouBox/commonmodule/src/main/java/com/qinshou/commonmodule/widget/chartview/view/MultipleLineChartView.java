package com.qinshou.commonmodule.widget.chartview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;

import com.qinshou.commonmodule.util.DisplayUtil;
import com.qinshou.commonmodule.widget.chartview.component.HorizontalLine;
import com.qinshou.commonmodule.widget.chartview.component.Line;
import com.qinshou.commonmodule.widget.chartview.component.LineList;
import com.qinshou.commonmodule.widget.chartview.component.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:多条线的折线图,支持普通折线,平滑曲线
 * 支持动态绘制
 * Created by 禽兽先生
 * Created on 2018/3/13
 */

public class MultipleLineChartView extends BaseChartView {
    private LineList mLineList;

    private Paint dataLinePaint;    //数据线的画笔
    private List<Path> pathList;
    private boolean isAnimateDraw = false;

    public MultipleLineChartView(Context context) {
        this(context, null);
    }

    public MultipleLineChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultipleLineChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint(context);
        pathList = new ArrayList<>();
    }

    private void initPaint(Context context) {
        dataLinePaint = new Paint();
        dataLinePaint.setAntiAlias(true);
        dataLinePaint.setStrokeWidth(DisplayUtil.dp2px(context, 1.5f));
        dataLinePaint.setColor(Color.rgb(255, 201, 54));
        dataLinePaint.setStyle(Paint.Style.STROKE);
        dataLinePaint.setStrokeCap(Paint.Cap.ROUND);
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

        if (mLineList == null) {
            return;
        }
        //画平滑曲线
        for (int i = 0; i < pathList.size(); i++) {
            dataLinePaint.setColor(mLineList.getLineList().get(i).getColor());
            canvas.drawPath(pathList.get(i), dataLinePaint);
        }

        for (int i = 0; i < pathList.size(); i++) {
            drawFillPath(canvas, mLineList.getLineList().get(i).getPointList());
        }

        for (int i = 0; getHorizontalLineList() != null && i < getHorizontalLineList().size(); i++) {
            HorizontalLine mHorizontalLine = getHorizontalLineList().get(i);
            if (mHorizontalLine.getLevel() == HorizontalLine.Level.ABOVE) {
                drawHorizontalLine(canvas, mHorizontalLine);
            }
        }
        drawHighlightPoint(canvas);

        drawTouchPosition(canvas);
    }

    /**
     * Description:将每个数据集合初始化成普通折线的 Path
     * Date:2018/3/13
     */
    private Path initLinearPath(List<Point> pointList) {
        Path mPath = new Path();
        mPath.reset();
        for (int i = 0; i < pointList.size(); i++) {
            if (i == 0) {
                pathMoveTo(mPath, getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            } else {
                pathLineTo(mPath, getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            }
        }
        return mPath;
    }

    /**
     * Description:将每个数据集合初始化成平滑曲线的 Path
     * Date:2018/3/13
     */
    private Path initBezierPath(List<Point> pointList) {
        Path mPath = new Path();
        mPath.reset();
        for (int i = 0; i < pointList.size(); i++) {
            if (i == 0) {
                pathMoveTo(mPath, getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            } else if (i == 1) {
                List<Point> controlPointList = getBezierControlPoint(pointList.get(i - 1), pointList.get(i - 1), pointList.get(i), pointList.get(i + 1));
                pathCubicTo(mPath, getEachX() * controlPointList.get(0).getX(), getEachY() * (getMax() - controlPointList.get(0).getY())
                        , getEachX() * controlPointList.get(1).getX(), getEachY() * (getMax() - controlPointList.get(1).getY())
                        , getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            } else if (i == pointList.size() - 1) {
                List<Point> controlPointList = getBezierControlPoint(pointList.get(i - 2), pointList.get(i - 1), pointList.get(i), pointList.get(i));
                pathCubicTo(mPath, getEachX() * controlPointList.get(0).getX(), getEachY() * (getMax() - controlPointList.get(0).getY())
                        , getEachX() * controlPointList.get(1).getX(), getEachY() * (getMax() - controlPointList.get(1).getY())
                        , getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            } else {
                List<Point> controlPointList = getBezierControlPoint(pointList.get(i - 2), pointList.get(i - 1), pointList.get(i), pointList.get(i + 1));
                pathCubicTo(mPath, getEachX() * controlPointList.get(0).getX(), getEachY() * (getMax() - controlPointList.get(0).getY())
                        , getEachX() * controlPointList.get(1).getX(), getEachY() * (getMax() - controlPointList.get(1).getY())
                        , getEachX() * pointList.get(i).getX(), getEachY() * (getMax() - pointList.get(i).getY()));
            }
        }
        return mPath;
    }

    private void initPathList(LineList linelist) {
        pathList.clear();
        for (Line line : linelist.getLineList()) {
            switch (line.getMode()) {
                case LINEAR:
                    pathList.add(initLinearPath(line.getPointList()));
                    break;
                case BEZIER:
                    pathList.add(initBezierPath(line.getPointList()));
                    break;
                case LINEAR_AND_FILL:
                    pathList.add(initLinearPath(line.getPointList()));
                    break;
                case BEZIER_AND_FILL:
                    pathList.add(initBezierPath(line.getPointList()));
                    break;
            }
        }
    }

    private void animateDraw() {
        if (!isAnimateDraw) {
            return;
        }
        for (final Path path : pathList) {
            final PathMeasure mPathMeasure = new PathMeasure();
            mPathMeasure.setPath(path, false);
            path.reset();
            ValueAnimator mValueAnimator = ValueAnimator.ofFloat(0f, 1f);
            mValueAnimator.setDuration(1000);
            mValueAnimator.setInterpolator(new LinearInterpolator());
            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float value = (float) animation.getAnimatedValue();
                    mPathMeasure.getSegment(0, mPathMeasure.getLength() * value, path, true);
                    invalidate();
                }
            });
            mValueAnimator.start();
        }
    }

    @Override
    public void setMax(float max) {
        super.setMax(max);
    }

    @Override
    public void setMin(float min) {
        super.setMin(min);
    }

    public boolean isAnimateDraw() {
        return isAnimateDraw;
    }

    public void setAnimateDraw(boolean animateDraw) {
        isAnimateDraw = animateDraw;
    }

    /**
     * Description:设置数据
     * Date:2018/3/14
     *
     * @param lineList 数据源
     */
    public void setLineList(LineList lineList) {
        this.mLineList = lineList;
        super.setMax(mLineList.getMax());
        super.setMin(mLineList.getMin());
    }

    public void draw() {
        this.post(new Runnable() {
            @Override
            public void run() {
                if (mLineList == null) {
                    return;
                }
                setEachX((float) getChartWidth() / (float) (mLineList.getMaxSize() - 1));
                setEachY((float) getChartHeight() / (getMax() - getMin()));
                initPathList(mLineList);
                animateDraw();
                invalidate();
            }
        });
    }

}
