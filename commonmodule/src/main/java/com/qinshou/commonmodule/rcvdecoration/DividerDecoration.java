package com.qinshou.commonmodule.rcvdecoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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
    public enum Orientation {
        HORIZONTAL,
        VERTICAL,
    }

    private Orientation mOrientation;
    private int mWidth;
    private Paint mPaint;

    private int mMarginLeft;
    private int mMarginTop;
    private int mMarginRight;
    private int mMarginBottom;
    /**
     * 是否显示最后一个 item 的分隔线
     */
    private boolean mShowLast = false;

    public DividerDecoration() {
        this(Orientation.VERTICAL);
    }

    public DividerDecoration(Orientation orientation) {
        this(orientation, 1);

    }

    public DividerDecoration(Orientation orientation, int width) {
        this(orientation, width, 0xFF000000);
    }

    public DividerDecoration(Orientation orientation, int width, @ColorInt int color) {
        mOrientation = orientation;
        mWidth = width;
        mPaint = new Paint();
        mPaint.setColor(color);
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (parent.getLayoutManager() == null) {
            return;
        }
        if (mOrientation == Orientation.VERTICAL) {
            drawVertical(c, parent);
        } else if (mOrientation == Orientation.HORIZONTAL) {
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
        if (mOrientation == Orientation.VERTICAL) {
            //outRect 相当于 Item 的整体绘制区域,设置 left、top、right、bottom 相当于设置左上右下的内间距
            //如设置 outRect.top = 5 则相当于设置 paddingTop 为 5px。
            if (position < adapter.getItemCount()) {
                outRect.bottom = mWidth;
            }
        } else if (mOrientation == Orientation.HORIZONTAL) {
            if (position < adapter.getItemCount()) {
                outRect.right = mWidth;
            }
        }
    }

    public void setMargin(int left, int top, int right, int bottom) {
        this.mMarginLeft = left;
        this.mMarginTop = top;
        this.mMarginRight = right;
        this.mMarginBottom = bottom;
    }

    public void setShowLast(boolean showLast) {
        mShowLast = showLast;
    }
}
