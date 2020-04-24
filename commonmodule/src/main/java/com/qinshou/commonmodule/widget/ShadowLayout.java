package com.qinshou.commonmodule.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.qinshou.commonmodule.R;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/2 16:07
 * Description:阴影控件
 * 该控件绘制阴影时会影响原控件的宽高
 */
public class ShadowLayout extends FrameLayout {
    private Paint mPaint;
    private RectF mRoundCornerRectF;
    /**
     * 背景颜色
     */
    private int mBgColor = 0xFFFFFFFF;
    /**
     * 阴影颜色
     */
    private int mShadowColor = 0xFFCCCCCC;
    /**
     * 阴影宽度
     */
    private float mShadowWidth = 20;
    /**
     * 阴影圆角度
     */
    private float mShadowRadius = 20;
    /**
     * 阴影在 X 轴上的偏移量
     */
    private float mShadowOffsetX = 0;
    /**
     * 阴影在 Y 轴上的偏移量
     */
    private float mShadowOffsetY = 0;

    public ShadowLayout(Context context) {
        this(context, null);
    }

    public ShadowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShadowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mBgColor);

        mRoundCornerRectF = new RectF();
        // 为了显示阴影,设置 padding,所以绘制阴影时会影响原控件的宽高
        setPadding((int) mShadowWidth, (int) mShadowWidth, (int) mShadowWidth, (int) mShadowWidth);
        initTypedArray(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        mPaint.setShadowLayer(mShadowRadius, mShadowOffsetX, mShadowOffsetY, mShadowColor);
        canvas.drawRoundRect(mRoundCornerRectF, mShadowRadius, mShadowRadius, mPaint);
        // 保存画布当前状态
        canvas.save();
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRoundCornerRectF.set(mShadowWidth, mShadowWidth, w - mShadowWidth, h - mShadowWidth);
        // 清除直接子控件的背景
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        View view = getChildAt(0);
        if (view == null) {
            return;
        }
        view.setBackground(null);
    }

    private void initTypedArray(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShadowLayout);
        mBgColor = typedArray.getColor(R.styleable.ShadowLayout_bgColor, 15);
        mShadowColor = typedArray.getColor(R.styleable.ShadowLayout_shadowColor, -1);
        mShadowWidth = typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_shadowWidth, -1);
        mShadowRadius = typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_shadowRadius, -1);
        mShadowOffsetX = typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_shadowOffsetX, -1);
        mShadowOffsetY = typedArray.getDimensionPixelSize(R.styleable.ShadowLayout_shadowOffsetY, -1);
        typedArray.recycle();
    }

    public int getBgColor() {
        return mBgColor;
    }

    public int getShadowColor() {
        return mShadowColor;
    }

    public float getShadowWidth() {
        return mShadowWidth;
    }

    public float getShadowRadius() {
        return mShadowRadius;
    }

    public float getShadowOffsetX() {
        return mShadowOffsetX;
    }

    public float getShadowOffsetY() {
        return mShadowOffsetY;
    }
}
