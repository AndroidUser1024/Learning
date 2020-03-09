package com.qinshou.commonmodule.rcvdecoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        this(orientation, width, 0xFF000000);
    }

    public GridDividerDecoration(Orientation orientation, int width, @ColorInt int color) {
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
        drawDivider(c, parent);
    }

    private void drawDivider(Canvas canvas, RecyclerView parent) {
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
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); //获取当前itemView的位置
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null) {
            return;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
        int spanCount = gridLayoutManager.getSpanCount() / gridLayoutManager.getSpanSizeLookup().getSpanSize(position);
        if ((position + 1) % spanCount != 0) {
            outRect.right = mWidth;
        }
        if (position < adapter.getItemCount() - spanCount) {
            outRect.bottom = mWidth;
        }
    }

    public void setMargin(int left, int top, int right, int bottom) {
        this.mMarginLeft = left;
        this.mMarginTop = top;
        this.mMarginRight = right;
        this.mMarginBottom = bottom;
    }
}
