package com.qinshou.qinshoubox.me.ui.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Description:爱心
 * Author: QinHao
 * Date: 2019/5/20 9:36
 */
public class LoveHeartView extends View {
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 500;
    private Paint mPaint;
    private Path mPath;
    private ValueAnimator mValueAnimator;

    public LoveHeartView(Context context) {
        this(context, null);
    }

    public LoveHeartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoveHeartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //setMaskFilter 添加阴影的方式不支持硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mPaint.setColor(0xFFFF0000);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(1f);
        //添加阴影
        mPaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.SOLID));

        mPath = new Path();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mValueAnimator != null && mValueAnimator.isRunning()) {
                    stopBeat();
                    return;
                }
                startBeat();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = (int) (getPaddingLeft() + DEFAULT_WIDTH + getPaddingRight());
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = (int) (getPaddingTop() + DEFAULT_HEIGHT + getPaddingBottom());
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath.moveTo((float) getMeasuredWidth() / 6 * 3, (float) getMeasuredHeight() / 6 * 2);
        //
        mPath.cubicTo((float) getMeasuredWidth() / 6 * 3, 0 + 50
                , (float) getMeasuredWidth() / 6 * 1, 0 + 50
                , (float) getMeasuredWidth() / 6 * 1, (float) getMeasuredHeight() / 6 * 2);
        //
        mPath.cubicTo((float) getMeasuredWidth() / 6 * 1, (float) getMeasuredHeight() / 6 * 4
                , (float) getMeasuredWidth() / 6 * 3, (float) getMeasuredHeight() / 6 * 4
                , (float) getMeasuredWidth() / 6 * 3, (float) getMeasuredHeight() / 6 * 5);
        //
        mPath.cubicTo((float) getMeasuredWidth() / 6 * 3, (float) getMeasuredHeight() / 6 * 4
                , (float) getMeasuredWidth() / 6 * 5, (float) getMeasuredHeight() / 6 * 4
                , (float) getMeasuredWidth() / 6 * 5, (float) getMeasuredHeight() / 6 * 2);
        //
        mPath.cubicTo((float) getMeasuredWidth() / 6 * 5, 0 + 50
                , (float) getMeasuredWidth() / 6 * 3, 0 + 50
                , (float) getMeasuredWidth() / 6 * 3, (float) getMeasuredHeight() / 6 * 2);
        canvas.drawPath(mPath, mPaint);
//        canvas.drawPoint((float) getMeasuredWidth() / 6 * 5, (float) getMeasuredHeight() / 6 * 2, mPaint);
    }

    public void startBeat() {
        mValueAnimator = ObjectAnimator.ofFloat(1f, 1.2f);
        mValueAnimator.setDuration(300);
        mValueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                LoveHeartView.this.setScaleX(value);
                LoveHeartView.this.setScaleY(value);
            }
        });
        mValueAnimator.start();
    }

    public void stopBeat() {
        if (mValueAnimator != null) {
            mValueAnimator.cancel();
        }
    }
}
