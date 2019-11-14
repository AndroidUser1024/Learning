package com.qinshou.qinshoubox.me.ui.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Description:八卦自定义控件
 * Author: QinHao
 * Date: 2019/5/20 9:36
 */
public class GossipView extends View {
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 500;
    private Paint mPaint;
    private RectF mRectF;
    private ObjectAnimator mObjectAnimator;

    public GossipView(Context context) {
        this(context, null);
    }

    public GossipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GossipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mRectF = new RectF();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mObjectAnimator != null && mObjectAnimator.isRunning()) {
                    stopRotation();
                    return;
                }
                startRotation();
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
            width = (getPaddingLeft() + DEFAULT_WIDTH + getPaddingRight());
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = (getPaddingTop() + DEFAULT_HEIGHT + getPaddingBottom());
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRectF.set(0, 0, getWidth(), (float) getHeight());
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(mRectF, 180, 360, true, mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawArc(mRectF, 0, 180, true, mPaint);

        mPaint.setColor(Color.BLACK);
        canvas.drawCircle((float) getWidth() / 4 * 3, (float) getHeight() / 2, (float) getWidth() / 4, mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawCircle((float) getWidth() / 4, (float) getHeight() / 2, (float) getWidth() / 4, mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawCircle((float) getWidth() / 4 * 3, (float) getHeight() / 2 + (float) getWidth() / 4 / 2, (float) getWidth() / 20, mPaint);

        mPaint.setColor(Color.BLACK);
        canvas.drawCircle((float) getWidth() / 4, (float) getHeight() / 2 - (float) getWidth() / 4 / 2, (float) getWidth() / 20, mPaint);
    }

    public void startRotation() {
        if (mObjectAnimator == null) {
            mObjectAnimator = ObjectAnimator.ofFloat(this, "rotation", 0, 360);
            mObjectAnimator.setRepeatCount(ValueAnimator.INFINITE);
            mObjectAnimator.setRepeatMode(ValueAnimator.RESTART);
            mObjectAnimator.setDuration(1000);
            mObjectAnimator.setInterpolator(new LinearInterpolator());
        }
        mObjectAnimator.setFloatValues(getRotation(), getRotation() + 360);
        mObjectAnimator.start();
    }

    public void stopRotation() {
        if (mObjectAnimator != null) {
            mObjectAnimator.cancel();
            mObjectAnimator = null;
        }
    }
}
