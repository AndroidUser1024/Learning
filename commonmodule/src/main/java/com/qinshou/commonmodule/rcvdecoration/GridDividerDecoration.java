package com.qinshou.commonmodule.rcvdecoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/6/20
 */

public class GridDividerDecoration extends RecyclerView.ItemDecoration {
    public enum Orientation {
        HORIZONTAL,
        VERTICAL,
    }

    private Orientation mOrientation;
    private int mWidth;
    private Paint mPaint;

    private int mMarginLeft = 0;
    private int mMarginTop = 0;
    private int mMarginRight = 0;
    private int mMarginBottom = 0;

    public GridDividerDecoration() {
        this(Orientation.VERTICAL);
    }

    public GridDividerDecoration(Orientation orientation) {
        this(orientation, 1);

    }

    public GridDividerDecoration(Orientation orientation, int width) {
        this(orientation, width, Color.BLACK);
    }

    public GridDividerDecoration(Orientation orientation, int width, @ColorInt int color) {
        mOrientation = orientation;
        mWidth = width;
        mPaint = new Paint();
        mPaint.setColor(color);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() == null) {
            return;
        }
//        if (mOrientation == Orientation.VERTICAL) {
//        drawVertical(c, parent);
//        } else if (mOrientation == Orientation.HORIZONTAL) {
        drawHorizontal(c, parent);
//        }
    }

    private void drawVertical(Canvas canvas, RecyclerView parent) {
        //Decoration 的左边位置
        int left = parent.getLeft() + mMarginLeft;
        //Decoration 的右边位置
        int right = parent.getRight() - mMarginRight;
        //获取 RecyclerView 的 Item 数量
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childView = parent.getChildAt(i);
            //Decoration 的底边位置
            int top = childView.getBottom();
            //Decoration 的顶边位置
            int bottom = top + mWidth;
            canvas.drawRect(left, top, right, bottom, mPaint);
        }
    }

    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        //获取 RecyclerView 的 Item 数量
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childView = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(childView);
            GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
            int spanCount = gridLayoutManager.getSpanCount() / gridLayoutManager.getSpanSizeLookup().getSpanSize(i);
            //画右边分隔线
            if ((position + 1) % spanCount != 0) {
                //Decoration 的顶边位置
                int top = childView.getTop() + mMarginTop;
                //Decoration 的底边位置
                int bottom = childView.getBottom() - mMarginBottom;
                //Decoration 的左边位置
                int left = childView.getRight();
                //Decoration 的右边位置
                int right = left + mWidth;
                canvas.drawRect(left, top, right, bottom, mPaint);
            }

            //画底边分隔线
            if (position < parent.getAdapter().getItemCount() - spanCount) {
                //Decoration 的底边位置
                int top = childView.getBottom();
                //Decoration 的顶边位置
                int bottom = top + mWidth;
                //Decoration 的左边位置
                int left = childView.getLeft() + mMarginLeft;
                //Decoration 的右边位置
                int right = childView.getRight() - mMarginRight;
                canvas.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); //获取当前itemView的位置
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null) {
            return;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
        int spanCount = gridLayoutManager.getSpanCount() / gridLayoutManager.getSpanSizeLookup().getSpanSize(position);
//        if (mOrientation == Orientation.VERTICAL) {
//            //outRect 相当于 Item 的整体绘制区域,设置 left、top、right、bottom 相当于设置左上右下的内间距
//            //如设置 outRect.top = 5 则相当于设置 paddingTop 为 5px。
//            if (position < adapter.getItemCount() - 1) {
//                outRect.top = mWidth;
//            }
//        } else if (mOrientation == Orientation.HORIZONTAL) {
        if ((position + 1) % spanCount != 0) {
            outRect.right = mWidth;
        }
        if (position < adapter.getItemCount() - spanCount) {
            outRect.bottom = mWidth;
        }
//        }
    }

    public void setMargin(int left, int top, int right, int bottom) {
        this.mMarginLeft = left;
        this.mMarginTop = top;
        this.mMarginRight = right;
        this.mMarginBottom = bottom;
    }
}
