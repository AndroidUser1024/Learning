package com.qinshou.qinshoubox.me.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/6/10 15:12
 * Description:波动侧边导航栏
 */
public class WaveSideBar extends View {
    private static final String TAG = "WaveSideBar";
    /**
     * 默认波动影响的 item 个数,即前后最多各有该个数的 item 会进行波动
     */
    private static final int WAVE_RANGE = 4;
    /**
     * 波动波峰值,即选中 item 的 x 偏移最大值
     */
    private static final int WAVE_CREST = 50;

    /**
     * 默认 item 集合
     */
    private final static String[] DEFAULT_ITEM_LIST = {"A", "B", "C", "D", "E", "F", "G"
            , "H", "I", "J", "K", "L", "M", "N"
            , "O", "P", "Q", "R", "S", "T"
            , "U", "V", "W", "StarCross", "Y", "Z"};

    private Paint mPaint;
    private Rect mTextBounds = new Rect();
    private float mTouchY = -1;
    private int mSelectedIndex = -1;
    private RectF mRectF = new RectF();
    /**
     * 所有 item 宽度的最大值
     */
    private int mItemMaxWidth;
    /**
     * 所有 item 高度的最大值
     */
    private int mItemMaxHeight;
    /**
     * 所有 item 高度的总和
     */
    private int mItemTotalHeight;

    /**
     * item 集合
     */
    private List<String> mItemList = new ArrayList<>();
    /**
     * item 的文字大小
     */
    private int mItemTextSize = 14;
    /**
     * 每个 item 的 marginTop 和 marginBottom
     */
    private int mItemMargin = 5;
    /**
     * item 的文字颜色
     */
    private int mItemTextColor = Color.GRAY;
    /**
     * 选中 item 的文字颜色
     */
    private int mItemSelectedTextColor = Color.BLACK;
    /**
     * 出现在屏幕中间显示选中 item 的弹出框
     */
    private int mItemSelectedPopupWindowSideLength = 50;
    /**
     * 弹出框的圆角度
     */
    private int mItemSelectedPopupWindowRadius = 20;
    /**
     * 弹出框的背景颜色
     */
    private int mItemSelectedPopupWindowBackgroundColor = 0xCCCCCCCC;
    /**
     * 弹出框的文字大小
     */
    private int mItemSelectedPopupWindowTextSize = 60;
    /**
     * 弹出框的文字颜色
     */
    private int mItemSelectedPopupWindowTextColor = 0xFFFFFFFF;
    /**
     * 导航栏的位置
     */
    private Position mPosition = Position.RIGHT;
    /**
     * 是否有波动效果
     */
    private boolean wave = true;
    /**
     * 是否显示选中 item 的弹出框
     */
    private boolean showItemSelectedPopupWindow = true;
    /**
     * item 选中监听器
     */
    private IOnItemSelectedListener mOnItemSelectedListener;


    public WaveSideBar(Context context) {
        this(context, null);
    }

    public WaveSideBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaveSideBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        setItemList(DEFAULT_ITEM_LIST);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(sp2px(mItemTextSize));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 控件宽高为屏幕宽高
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mItemList.size(); i++) {
            String item = mItemList.get(i);
            // 重置画笔的 TextSize 和 TextColor
            mPaint.setTextSize(sp2px(mItemTextSize));
            mPaint.setColor(mItemTextColor);
            // 获取绘制文字的矩形范围
            mPaint.getTextBounds(item, 0, item.length(), mTextBounds);
            // 计算正常情况下的 x,y 坐标
            float y = (float) getMeasuredHeight() / 2 - (float) mItemTotalHeight / 2 + mItemMaxHeight * (i + 1) - (float) mTextBounds.height() / 2;
            float x;
            if (mPosition == Position.LEFT) {
                x = (float) mItemMaxWidth / 2 - (float) mTextBounds.width() / 2;
            } else {
//                x = getMeasuredWidth() - mItemMaxWidth + (mItemMaxWidth / 2 - mTextBounds.width() / 2);
                x = getMeasuredWidth() - mItemMaxWidth / 2 - mTextBounds.width() / 2;
            }
            // 计算触摸点与当前绘制 item 的 y 坐标的偏移量
            float yOffset = y - mTouchY;
            // 根据 y 坐标的偏移量计算触摸点偏移了几个 item
            float indexOffset = yOffset / mItemMaxHeight;

            if (mTouchY == -1 || mSelectedIndex == -1) {
                // 没有触摸事件,正常绘制
                canvas.drawText(item, x, y, mPaint);
            } else {
                // 有触摸事件,且需要波动效果
                if (Math.abs(indexOffset) <= WAVE_RANGE && wave) {
                    // 波动范围内的 item 动态计算 x 坐标
                    // 根据 WAVE_RANGE 计算变化的分數,范围 0-1 之间
                    float fraction = (WAVE_RANGE - Math.abs(indexOffset)) / WAVE_RANGE;
                    // 计算 x 坐标
                    if (mPosition == Position.LEFT) {
                        x += fraction * dp2px(WAVE_CREST);
                    } else {
                        x -= fraction * dp2px(WAVE_CREST);
                    }
                    float textSize = mItemTextSize + 0.5f * fraction * sp2px(mItemTextSize);
                    // 计算 TextSize
                    mPaint.setTextSize(sp2px((int) textSize));
                    // 计算 TextColor
                    mPaint.setColor(getCurrentColor(fraction
                            , mItemTextColor
                            , mItemSelectedTextColor));
                    canvas.drawText(item, x, y, mPaint);
                } else {
                    // 波动范围外的 item 正常绘制
                    canvas.drawText(item, x, y, mPaint);
                }
                // 如果需要显示选中 item 的弹出框
                if (showItemSelectedPopupWindow) {
                    // 绘制中间显示选中 item 的弹出框
                    // 获取当前选中的 item
                    String selectedItem = mItemList.get(mSelectedIndex);
                    // 绘制背景
                    mPaint.setColor(mItemSelectedPopupWindowBackgroundColor);
                    mRectF.set((float) getMeasuredWidth() / 2 - dp2px(mItemSelectedPopupWindowSideLength),
                            (float) getMeasuredHeight() / 2 - dp2px(mItemSelectedPopupWindowSideLength),
                            (float) getMeasuredWidth() / 2 + dp2px(mItemSelectedPopupWindowSideLength),
                            (float) getMeasuredHeight() / 2 + dp2px(mItemSelectedPopupWindowSideLength));
                    canvas.drawRoundRect(mRectF, dp2px(mItemSelectedPopupWindowRadius), dp2px(mItemSelectedPopupWindowRadius), mPaint);
                    // 绘制文字
                    mPaint.setTextSize(sp2px(mItemSelectedPopupWindowTextSize));
                    mPaint.setColor(mItemSelectedPopupWindowTextColor);
                    mPaint.getTextBounds(selectedItem, 0, selectedItem.length(), mTextBounds);
                    canvas.drawText(selectedItem,
                            (float) getMeasuredWidth() / 2 - (float) mTextBounds.width() / 2,
                            (float) getMeasuredHeight() / 2 + (float) mTextBounds.height() / 2,
                            mPaint);
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (mPosition == Position.LEFT) {
                    if (event.getX() < 0 || event.getX() > mItemMaxWidth) {
                        return false;
                    }
                } else {
                    if (event.getX() > getMeasuredWidth() || event.getX() < getMeasuredWidth() - mItemMaxWidth) {
                        return false;
                    }
                }
                mTouchY = event.getY();
                mSelectedIndex = getSelectedIndex(event.getY());
                if (mSelectedIndex >= 0 && mSelectedIndex < mItemList.size() && mOnItemSelectedListener != null) {
                    // 监听器回调
                    mOnItemSelectedListener.onItemSelected(mSelectedIndex, mItemList.get(mSelectedIndex));
                }
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                mTouchY = event.getY();
                mSelectedIndex = getSelectedIndex(event.getY());
                if (mSelectedIndex >= 0 && mSelectedIndex < mItemList.size() && mOnItemSelectedListener != null) {
                    // 监听器回调
                    mOnItemSelectedListener.onItemSelected(mSelectedIndex, mItemList.get(mSelectedIndex));
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mTouchY = -1;
                mSelectedIndex = -1;
                if (mOnItemSelectedListener != null) {
                    // 监听器回调
                    mOnItemSelectedListener.onCancel();
                }
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/6/3 9:04
     * Description:获取一个过渡期中当前颜色,fraction 为过渡系数,取值范围 0f-1f,值越接近 1,颜色就越接近 endColor
     *
     * @param fraction   当前渐变系数
     * @param startColor 过渡开始颜色
     * @param endColor   过渡结束颜色
     * @return 当前颜色
     */
    private int getCurrentColor(float fraction, int startColor, int endColor) {
        int redStart = Color.red(startColor);
        int blueStart = Color.blue(startColor);
        int greenStart = Color.green(startColor);
        int alphaStart = Color.alpha(startColor);

        int redEnd = Color.red(endColor);
        int blueEnd = Color.blue(endColor);
        int greenEnd = Color.green(endColor);
        int alphaEnd = Color.alpha(endColor);

        int redDifference = redEnd - redStart;
        int blueDifference = blueEnd - blueStart;
        int greenDifference = greenEnd - greenStart;
        int alphaDifference = alphaEnd - alphaStart;

        int redCurrent = (int) (redStart + fraction * redDifference);
        int blueCurrent = (int) (blueStart + fraction * blueDifference);
        int greenCurrent = (int) (greenStart + fraction * greenDifference);
        int alphaCurrent = (int) (alphaStart + fraction * alphaDifference);

        return Color.argb(alphaCurrent, redCurrent, greenCurrent, blueCurrent);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/7/1 9:21
     * Description:获取选中 item 的 index
     *
     * @param eventY 触摸点的 y 坐标
     * @return 选中 item 的 index
     */
    private int getSelectedIndex(float eventY) {
        if (eventY < (getMeasuredHeight() / 2 - mItemTotalHeight / 2)
                || eventY > (getMeasuredHeight() / 2 + mItemTotalHeight / 2)) {
            return -1;
        }
        float marginTop = (float) getMeasuredHeight() / 2 - (float) mItemTotalHeight / 2;
        return (int) ((eventY - marginTop) / mItemMaxHeight);
    }

    private float dp2px(int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    private float sp2px(int sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
    }

    public enum Position {
        LEFT,
        RIGHT,
    }

    public interface IOnItemSelectedListener {
        void onItemSelected(int position, String item);

        void onCancel();
    }

    public void setItemList(String[] itemArray) {
        setItemList(Arrays.asList(itemArray));
    }

    public void setItemList(List<String> itemList) {
        mItemList = itemList;
        for (String s : mItemList) {
            mPaint.getTextBounds(s, 0, s.length(), mTextBounds);
            mItemMaxWidth = Math.max(mItemMaxWidth, mTextBounds.width());
            mItemMaxHeight = Math.max(mItemMaxHeight, (int) dp2px(mItemMargin) + mTextBounds.height() + (int) dp2px(mItemMargin));
        }
        mItemTotalHeight = mItemMaxHeight * mItemList.size();
    }

    public void setItemTextSize(int itemTextSize) {
        mItemTextSize = itemTextSize;
    }

    public void setItemMargin(int itemMargin) {
        mItemMargin = itemMargin;
    }

    public void setItemTextColor(int itemTextColor) {
        mItemTextColor = itemTextColor;
    }

    public void setItemSelectedTextColor(int itemSelectedTextColor) {
        mItemSelectedTextColor = itemSelectedTextColor;
    }

    public void setItemSelectedPopupWindowSideLength(int itemSelectedPopupWindowSideLength) {
        mItemSelectedPopupWindowSideLength = itemSelectedPopupWindowSideLength;
    }

    public void setItemSelectedPopupWindowRadius(int itemSelectedPopupWindowRadius) {
        mItemSelectedPopupWindowRadius = itemSelectedPopupWindowRadius;
    }

    public void setItemSelectedPopupWindowBackgroundColor(int itemSelectedPopupWindowBackgroundColor) {
        mItemSelectedPopupWindowBackgroundColor = itemSelectedPopupWindowBackgroundColor;
    }

    public void setItemSelectedPopupWindowTextSize(int itemSelectedPopupWindowTextSize) {
        mItemSelectedPopupWindowTextSize = itemSelectedPopupWindowTextSize;
    }

    public void setItemSelectedPopupWindowTextColor(int itemSelectedPopupWindowTextColor) {
        mItemSelectedPopupWindowTextColor = itemSelectedPopupWindowTextColor;
    }

    public void setPosition(Position position) {
        mPosition = position;
        invalidate();
    }

    public void setWave(boolean wave) {
        this.wave = wave;
    }

    public void setShowItemSelectedPopupWindow(boolean showItemSelectedPopupWindow) {
        this.showItemSelectedPopupWindow = showItemSelectedPopupWindow;
    }

    public void setOnItemSelectedListener(IOnItemSelectedListener onItemSelectedListener) {
        mOnItemSelectedListener = onItemSelectedListener;
    }
}
