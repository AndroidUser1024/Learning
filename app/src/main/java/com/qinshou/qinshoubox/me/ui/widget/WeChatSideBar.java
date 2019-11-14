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
 * Date: 2019/11/14 15:40
 * Description:类描述
 */
public class WeChatSideBar extends View {
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
            , "U", "V", "W", "X", "Y", "Z"};

    private Paint mPaint;
    private Rect mTextBounds = new Rect();
    private float mTouchY = -1;
    private int mSelectedIndex = -1;
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
    private int mItemSelectedTextColor = Color.WHITE;
    /**
     * 选中 item 的文字颜色
     */
    private int mItemSelectedBackgroundColor = Color.GREEN;
    /**
     * 导航栏的位置
     */
    private Position mPosition = Position.LEFT;
    /**
     * item 选中监听器
     */
    private IOnItemSelectedListener mOnItemSelectedListener;


    public WeChatSideBar(Context context) {
        this(context, null);
    }

    public WeChatSideBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeChatSideBar(Context context, AttributeSet attrs, int defStyleAttr) {
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

            if (mTouchY == -1 || mSelectedIndex == -1 || i != mSelectedIndex) {
                // 没有触摸事件,正常绘制
                canvas.drawText(item, x, y, mPaint);
            } else {
                mPaint.setColor(mItemSelectedBackgroundColor);
                canvas.drawCircle(x, y,mItemMaxWidth, mPaint);
                // 重置画笔的 TextSize 和 TextColor
                mPaint.setTextSize(sp2px(mItemTextSize));
                mPaint.setColor(mItemSelectedTextColor);
                // 绘制文字
                canvas.drawText(item, x, y, mPaint);
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

    private float dp2px(int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    private float sp2px(int sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
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

    public enum Position {
        LEFT,
        RIGHT,
    }

    public interface IOnItemSelectedListener {
        void onItemSelected(int position, String item);

        void onCancel();
    }
}
