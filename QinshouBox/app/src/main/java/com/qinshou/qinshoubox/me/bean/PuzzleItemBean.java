package com.qinshou.qinshoubox.me.bean;

import android.graphics.Bitmap;

/**
 * Description:拼图块实体类
 * Created by 禽兽先生
 * Created on 2018/8/29
 */
public class PuzzleItemBean {
    private int mItemPosition;  //拼图块的位置
    private int mBitmapId;  //实际上也是拼图块的位置
    private Bitmap mBitmap; //拼图块的图片

    public PuzzleItemBean() {
    }

    public PuzzleItemBean(int itemPosition, int bitmapId, Bitmap bitmap) {
        mItemPosition = itemPosition;
        mBitmapId = bitmapId;
        mBitmap = bitmap;
    }

    public int getItemPosition() {
        return mItemPosition;
    }

    public void setItemPosition(int itemPosition) {
        mItemPosition = itemPosition;
    }

    public int getBitmapId() {
        return mBitmapId;
    }

    public void setBitmapId(int bitmapId) {
        mBitmapId = bitmapId;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
    }

    @Override
    public String toString() {
        return "PuzzleItemBean{" +
                "mItemPosition=" + mItemPosition +
                ", mBitmapId=" + mBitmapId +
                ", mBitmap=" + mBitmap +
                '}';
    }
}
