package com.qinshou.commonmodule.rcvdecoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description:RecyclerView 粘性头部效果的 Decoration
 * Created by 禽兽先生
 * Created on 2018/9/12
 */

public abstract class StickyDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "StickyDecoration";
    private Paint mPaint;   //分隔线画笔
    private int mHeight; //分隔线默认高度
    private int mBackGroundColor; //分隔线默认颜色
    private TextPaint mTextPaint;   //文字画笔
    private int mTextColor; //粘性头部文字颜色
    private Rect mTextBounds;   //分隔线文字范围

    private int mSpanCount; //GridLayoutManager 的 SpanSize
    private GridLayoutManager mGridLayoutManager;   //适配 SpanSize 动态变化时需传入 GridLayoutManager
    //使用 Map 来存储 RecyclerView.OnItemTouchListener,键为 StickyHeaderName，保证每一个粘性头部只有一个监听器
    private Map<String, RecyclerView.OnItemTouchListener> mOnItemTouchListenerMap = new HashMap<>();
    //使用 Set 来存储当前显示的 StickyHeaderName
    private Set<String> currentShowStickyHeaderNameSet = new HashSet<>();

    /**
     * Description:该构造方法一般用于 LinearLayoutManager
     * Date:2018/12/14
     */
    public StickyDecoration() {
        this(1);
    }

    /**
     * Description:该构造方法一般用于 GridLayoutManager
     * Date:2018/12/14
     */
    public StickyDecoration(int spanCount) {
//        mHeight = 100;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.parseColor("#FF000000"));
        mTextPaint.setTextSize(48f);
        mTextBounds = new Rect();

        mSpanCount = spanCount;
    }

    /**
     * Description:该构造方法一般用于 SpanSize 会变化的 GridLayoutManager
     * Date:2018/12/14
     */
    public StickyDecoration(GridLayoutManager gridLayoutManager) {
        this(gridLayoutManager.getSpanCount());
        mGridLayoutManager = gridLayoutManager;
    }

    /**
     * Description:在 Canvas 上绘制内容作为 RecyclerView 的 Item 的装饰，会在 Item 绘制之前绘制
     * 也就是说，如果该 Decoration 没有设置偏移的话，Item 的内容会覆盖该 Decoration。
     * Date:2018/9/14
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    /**
     * Description:在 Canvas 上绘制内容作为 RecyclerView 的 Item 的装饰，会在 Item 绘制之后绘制
     * 也就是说，如果该 Decoration 没有设置偏移的话，该 Decoration 会覆盖 Item 的内容。
     * Date:2018/9/14
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        String previousStickyHeaderName = null;
        String currentStickyHeaderName = null;
        final int left = parent.getLeft();
        //Decoration 的右边位置
        final int right = parent.getRight();
        //获取 RecyclerView 的 Item 数量
        int childCount = parent.getChildCount();
        //清空当前显示的 StickyHeaderName 集合
        currentShowStickyHeaderNameSet.clear();
        for (int i = 0; i < childCount; ) {
            View childView = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(childView);
            mPaint.setColor(getBackGroundColor(position));
            if (mGridLayoutManager != null) {
                //适配 GridLayoutManager 的 SpanSize 动态变化的情况，动态计算 mSpanCount
                mSpanCount = mGridLayoutManager.getSpanCount() / mGridLayoutManager.getSpanSizeLookup().getSpanSize(position);
            }
            currentStickyHeaderName = getStickyHeaderName(position);
            //如果粘性头部的文字为空则跳过绘制
            if (TextUtils.isEmpty(currentStickyHeaderName)) {
                //i 的变化量为 mSpanCount，为了在 GridLayoutManager 中不去重复比较同一行的 item
                i += mSpanCount;
                continue;
            }
            int nextStickyHeaderNameIndex = position + mSpanCount >= parent.getAdapter().getItemCount()
                    ? parent.getAdapter().getItemCount() - 1
                    : position + mSpanCount;
            //判断上一个 position 粘性头部的文字与当前 position 的粘性头部文字是否相同，如果不相同才绘制
            if (position >= mSpanCount) {
                previousStickyHeaderName = getStickyHeaderName(position - mSpanCount);
            }
            //当 position 或 i 小于 mSpanCount 时，即第一行的 item，绘制分隔线
            //当上一个粘性头部的文字与当前即将位置的粘性头部的文字不同时，绘制分隔线
            if (position < mSpanCount || i < mSpanCount || !TextUtils.equals(previousStickyHeaderName, currentStickyHeaderName)) {
                //Decoration 的底边位置
                int bottom = Math.max(childView.getTop(), getHeight(position));
                View nextChildView = parent.getChildAt(i + mSpanCount);
                String nextStickyHeaderName = getStickyHeaderName(nextStickyHeaderNameIndex);
                //当当前 Decoration 的 Bottom 比下一个 View 的 Decoration 的 Top （即下一个 View 的 getTop() - mHeight）大时
                //就应该使当前 Decoration 的 Bottom 等于下一个 Decoration 的 Top，形成推动效果
                if (nextChildView != null && !TextUtils.equals(currentStickyHeaderName, nextStickyHeaderName) && bottom > (nextChildView.getTop() - getHeight(position))) {
                    bottom = nextChildView.getTop() - getHeight(position);
                }
                //Decoration 的顶边位置
                final int top = bottom - getHeight(position);
                c.drawRect(left, top, right, bottom, mPaint);
                //绘制文字
                mTextPaint.setColor(getTextColor(position));
                mTextPaint.getTextBounds(currentStickyHeaderName, 0, currentStickyHeaderName.length(), mTextBounds);
                c.drawText(currentStickyHeaderName, left, bottom - getHeight(position) / 2 + mTextBounds.height() / 2, mTextPaint);

                //存储当前显示的 StickyHeaderName
                currentShowStickyHeaderNameSet.add(currentStickyHeaderName);
                //因为 RecyclerView 添加 ItemTouchListener 是 add 并不是 set，为了防止多次添加，先 remove 一下
                parent.removeOnItemTouchListener(mOnItemTouchListenerMap.get(currentStickyHeaderName));
                MyOnItemTouchListener myOnItemTouchListener = new MyOnItemTouchListener(left, right, top, bottom, currentStickyHeaderName);
                parent.addOnItemTouchListener(myOnItemTouchListener);
                mOnItemTouchListenerMap.put(currentStickyHeaderName, myOnItemTouchListener);
            }
            i += mSpanCount;
        }
    }

    /**
     * Description:为 Decoration 设置偏移
     * Date:2018/9/14
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //outRect 相当于 Item 的整体绘制区域,设置 left、top、right、bottom 相当于设置左上右下的内间距
        //如设置 outRect.top = 5 则相当于设置 paddingTop 为 5px。
        int position = parent.getChildAdapterPosition(view);
        if (mGridLayoutManager != null) {
            mSpanCount = mGridLayoutManager.getSpanCount() / mGridLayoutManager.getSpanSizeLookup().getSpanSize(position);
        }
        String currentStickyHeaderName = getStickyHeaderName(position);
        if (TextUtils.isEmpty(currentStickyHeaderName)) {
            return;
        }
        String previousStickyHeaderName = null;
        if (position >= mSpanCount) {
            previousStickyHeaderName = getStickyHeaderName(position - mSpanCount);
        }
        if (position < mSpanCount || !TextUtils.equals(previousStickyHeaderName, currentStickyHeaderName)) {
            outRect.top = getHeight(position);
        }
    }

    private class MyOnItemTouchListener extends RecyclerView.SimpleOnItemTouchListener {

        private int left;
        private int right;
        private int top;
        private int bottom;
        private String currentStickyHeaderName;
        boolean isPress = false;

        public MyOnItemTouchListener(int left, int right, int top, int bottom, String currentStickyHeaderName) {
            this.left = left;
            this.right = right;
            this.top = top;
            this.bottom = bottom;
            this.currentStickyHeaderName = currentStickyHeaderName;
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            if (e.getAction() == MotionEvent.ACTION_DOWN) {
                //在 StickyHeader 范围内按下时，置标志位为 true
                if (e.getX() > left && e.getX() < right
                        && e.getY() > top && e.getY() < bottom) {
                    isPress = true;
                }
            } else if (e.getAction() == MotionEvent.ACTION_UP) {
                //如果之前在 StickyHeader 范围内按下，且当前该 StickyHeaderName 正在显示，且抬起时仍在 StickyHeader 范围内
                //则认为是 StickyHeader 的一次点击事件
                if (isPress && currentShowStickyHeaderNameSet.contains(currentStickyHeaderName)
                        && e.getX() > left && e.getX() < right
                        && e.getY() > top && e.getY() < bottom) {
                    onClick(currentStickyHeaderName);
                }
                isPress = false;
            }
            return false;
        }

    }

    /**
     * author：MrQinshou
     * Description:提供给外部设置每一个 position 的粘性头部的文字的方法
     * date:2018/10/14 22:14
     * param
     * return
     */
    public abstract String getStickyHeaderName(int position);

    /**
     * author：MrQinshou
     * Description:重写该方法来设置分隔线高度
     * date:2018/12/14 10:50
     * param
     * return 分隔线高度
     */
    public int getHeight(int position) {
        return mHeight;
    }

    /**
     * author：MrQinshou
     * Description:重写该方法来设置分隔线背景颜色
     * date:2018/12/14 15:54
     * param
     * return 分隔线高度
     */
    public int getBackGroundColor(int position) {
        return mBackGroundColor;
    }

    /**
     * author：MrQinshou
     * Description:重写该方法来设置文字颜色
     * date:2018/12/14 15:54
     * param
     * return 分隔线高度
     */
    public int getTextColor(int position) {
        return mTextColor;
    }

    public void onClick(String clickStickyHeaderName) {
        Log.d(TAG, "onClick--->" + clickStickyHeaderName);
    }
}