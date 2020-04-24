package com.qinshou.commonmodule.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.qinshou.commonmodule.R;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/2/28 15:22
 * Description:圆角布局
 */
public class RoundCornerLayout extends FrameLayout {
    private Paint mPaint;
    private RectF mRoundCornerRectF;
    private Path mPath;
    private float[] mRoundCornerArray = new float[8];

    public RoundCornerLayout(Context context) {
        this(context, null);
    }

    public RoundCornerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundCornerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        // 设置画笔绘制两部分的交集
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        mRoundCornerRectF = new RectF();
        mPath = new Path();

        initTypedArray(context, attrs);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            // 保存画布当前状态
            canvas.save();
            mPath.reset();
            mPath.addRoundRect(mRoundCornerRectF, mRoundCornerArray, Path.Direction.CW);
            // 裁剪圆角
            canvas.clipPath(mPath);
            // 绘制子控件
            super.dispatchDraw(canvas);
            // 恢复画布状态
            canvas.restore();
        } else {
            // 保存画布当前状态
            canvas.saveLayer(mRoundCornerRectF, null, Canvas.ALL_SAVE_FLAG);
            // 绘制子控件
            super.dispatchDraw(canvas);
            // 绘制圆角
            mPath.reset();
            mPath.addRoundRect(mRoundCornerRectF, mRoundCornerArray, Path.Direction.CW);
            canvas.drawPath(mPath, mPaint);
            // 恢复画布状态
            canvas.restore();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRoundCornerRectF.set(0, 0, w, h);
    }

    private void initTypedArray(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundCornerLayout);
        int radius = typedArray.getDimensionPixelSize(R.styleable.RoundCornerLayout_radius, 15);
        int leftTopRadius = typedArray.getDimensionPixelSize(R.styleable.RoundCornerLayout_leftTopRadius, -1);
        int leftBottomRadius = typedArray.getDimensionPixelSize(R.styleable.RoundCornerLayout_leftBottomRadius, -1);
        int rightTopRadius = typedArray.getDimensionPixelSize(R.styleable.RoundCornerLayout_rightTopRadius, -1);
        int rightBottomRadius = typedArray.getDimensionPixelSize(R.styleable.RoundCornerLayout_rightBottomRadius, -1);
        typedArray.recycle();
        if (leftTopRadius == -1) {
            mRoundCornerArray[0] = radius;
            mRoundCornerArray[1] = radius;
        } else {
            mRoundCornerArray[0] = leftTopRadius;
            mRoundCornerArray[1] = leftTopRadius;
        }
        if (leftBottomRadius == -1) {
            mRoundCornerArray[2] = radius;
            mRoundCornerArray[3] = radius;
        } else {
            mRoundCornerArray[2] = leftBottomRadius;
            mRoundCornerArray[3] = leftBottomRadius;
        }
        if (rightTopRadius == -1) {
            mRoundCornerArray[4] = radius;
            mRoundCornerArray[5] = radius;
        } else {
            mRoundCornerArray[4] = leftTopRadius;
            mRoundCornerArray[5] = leftTopRadius;
        }
        if (rightBottomRadius == -1) {
            mRoundCornerArray[6] = radius;
            mRoundCornerArray[7] = radius;
        } else {
            mRoundCornerArray[6] = leftTopRadius;
            mRoundCornerArray[7] = leftTopRadius;
        }
    }
}
