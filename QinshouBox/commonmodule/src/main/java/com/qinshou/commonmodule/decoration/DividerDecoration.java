package com.qinshou.commonmodule.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Description:RecyclerView 分隔线效果的 Decoration
 * Created by 禽兽先生
 * Created on 2018/9/12
 */

public class DividerDecoration extends RecyclerView.ItemDecoration {
    private int mHeight;
    private Paint mPaint;
    private int mSpanCount;

    public DividerDecoration(Context context) {
        this(context, 0);
    }

    public DividerDecoration(Context context, int height) {
        this(context, height, 1);
    }

    public DividerDecoration(Context context, int height, int spanCount) {
        mHeight = height == 0 ? dp2px(context, 1) : dp2px(context, height);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GRAY);

        mSpanCount = spanCount;
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
        int left = parent.getLeft();
        //Decoration 的右边位置
        int right = parent.getRight();
        //获取 RecyclerView 的 Item 数量
        int childCount = parent.getChildCount();
        for (int i = 1; i < childCount; i++) {
            View childView = parent.getChildAt(i);
            //Decoration 的底边位置
            int bottom = childView.getTop();
            //Decoration 的顶边位置
            int top = bottom - mHeight;
            c.drawRect(left, top, right, bottom, mPaint);
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
        outRect.top = mHeight;
    }

    private int dp2px(Context context, float dpValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5f);
    }
}
