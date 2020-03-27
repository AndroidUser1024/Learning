package com.qinshou.commonmodule.rcvdecoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Description:RecyclerView 分隔线样式的 Decoration
 * Created by 禽兽先生
 * Created on 2018/6/20
 */

public class DividerDecoration extends RecyclerView.ItemDecoration {
    /**
     * 绘制分隔线的方向
     */
    private Builder.Orientation mOrientation;
    /**
     * 分隔线宽度
     */
    private int mWidth;
    /**
     * 分隔线距离左边的距离,垂直方向时有效
     */
    private int mMarginLeft;
    /**
     * 分隔线距离顶部的距离,水平方向时有效
     */
    private int mMarginTop;
    /**
     * 分隔线距离右边的距离,垂直方向时有效
     */
    private int mMarginRight;
    /**
     * 分隔线距离底部的距离,水平方向时有效
     */
    private int mMarginBottom;
    /**
     * 是否显示最后一个 item 的分隔线
     */
    private boolean mShowLast;
    private Paint mPaint;

    public DividerDecoration(Builder builder) {
        mOrientation = builder.mOrientation;
        mWidth = builder.mWidth;
        mMarginLeft = builder.mMarginLeft;
        mMarginTop = builder.mMarginTop;
        mMarginRight = builder.mMarginRight;
        mMarginBottom = builder.mMarginBottom;
        mShowLast = builder.mShowLast;
        mPaint = new Paint();
        mPaint.setColor(builder.mColor);
    }

    public DividerDecoration() {
        this(new Builder());
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (parent.getLayoutManager() == null) {
            return;
        }
        if (mOrientation == Builder.Orientation.VERTICAL) {
            drawVertical(c, parent);
        } else if (mOrientation == Builder.Orientation.HORIZONTAL) {
            drawHorizontal(c, parent);
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView parent) {
        //Decoration 的左边位置
        int left = parent.getLeft() + mMarginLeft;
        //Decoration 的右边位置
        int right = parent.getRight() - mMarginRight;
        //获取 RecyclerView 的 Item 数量
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i == childCount - 1 && !mShowLast) {
                break;
            }
            View childView = parent.getChildAt(i);
            //Decoration 的底边位置
            int top = childView.getBottom();
            //Decoration 的顶边位置
            int bottom = top + mWidth;
            canvas.drawRect(left, top, right, bottom, mPaint);
        }
    }

    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        //Decoration 的顶边位置
        int top = parent.getTop() + mMarginTop;
        //Decoration 的底边位置
        int bottom = parent.getBottom() - mMarginBottom;
        //获取 RecyclerView 的 Item 数量
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            if (i == childCount - 1 && !mShowLast) {
                break;
            }
            View childView = parent.getChildAt(i);
            //Decoration 的左边位置
            int left = childView.getRight();
            //Decoration 的右边位置
            int right = left + mWidth;
            canvas.drawRect(left, top, right, bottom, mPaint);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); //获取当前itemView的位置
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null) {
            return;
        }
        if (mOrientation == Builder.Orientation.VERTICAL) {
            //outRect 相当于 Item 的整体绘制区域,设置 left、top、right、bottom 相当于设置左上右下的内间距
            //如设置 outRect.top = 5 则相当于设置 paddingTop 为 5px。
            if (position < adapter.getItemCount()) {
                outRect.bottom = mWidth;
            }
        } else if (mOrientation == Builder.Orientation.HORIZONTAL) {
            if (position < adapter.getItemCount()) {
                outRect.right = mWidth;
            }
        }
    }

    public static class Builder {
        private Builder.Orientation mOrientation;
        private int mWidth = 1;
        private int mColor = 0xFF000000;
        private int mMarginLeft = 0;
        private int mMarginTop = 0;
        private int mMarginRight = 0;
        private int mMarginBottom = 0;
        private boolean mShowLast = false;

        public enum Orientation {
            HORIZONTAL,
            VERTICAL,
        }

        public Builder setOrientation(Orientation orientation) {
            mOrientation = orientation;
            return this;
        }

        public Builder setWidth(int width) {
            mWidth = width;
            return this;
        }

        public Builder setColor(int color) {
            mColor = color;
            return this;
        }

        public Builder setMarginLeft(int marginLeft) {
            mMarginLeft = marginLeft;
            return this;
        }

        public Builder setMarginTop(int marginTop) {
            mMarginTop = marginTop;
            return this;
        }

        public Builder setMarginRight(int marginRight) {
            mMarginRight = marginRight;
            return this;
        }

        public Builder setMarginBottom(int marginBottom) {
            mMarginBottom = marginBottom;
            return this;
        }

        public Builder setShowLast(boolean showLast) {
            mShowLast = showLast;
            return this;
        }

        public DividerDecoration build() {
            return new DividerDecoration(this);
        }
    }
}
