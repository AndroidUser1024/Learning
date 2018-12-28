package com.qinshou.commonmodule.chartview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
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
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.qinshou.commonmodule.chartview.component.DataLine;
import com.qinshou.commonmodule.chartview.component.DataPoint;
import com.qinshou.commonmodule.chartview.component.HorizontalLine;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.widget.chartview.component.Axis;
import com.qinshou.commonmodule.widget.chartview.component.Label;

import java.util.ArrayList;
import java.util.List;


public class ChartView extends View {
    private int mWidth;
    private int mHeight;

    private Paint mPaint;
    private Path mPath;
    private Path mAnimatePath;
    private boolean mAnimateDraw = true;

    public ChartView(Context context) {
        this(context, null);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5f);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath = new Path();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                animate(mPath);
            }
        });
        mAnimatePath = new Path();
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
        mPath.moveTo(0, 0);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                mPath.lineTo(mWidth / 10 * i, 0);
            } else {
                mPath.lineTo(mWidth / 10 * i, mHeight);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mAnimateDraw) {
            canvas.drawPath(mAnimatePath, mPaint);
        } else {
            canvas.drawPath(mPath, mPaint);
        }
    }

    private void animate(final Path path) {
        final PathMeasure pathMeasure = new PathMeasure(path, false);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                pathMeasure.getSegment(0, pathMeasure.getLength() * value, mAnimatePath, true);
                invalidate();
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ShowLogUtil.logi("onAnimationEnd");
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                ShowLogUtil.logi("onAnimationStart");
                mAnimatePath.reset();
            }
        });
        valueAnimator.start();
    }

}
