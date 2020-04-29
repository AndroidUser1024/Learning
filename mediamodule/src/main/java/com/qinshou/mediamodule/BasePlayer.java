package com.qinshou.mediamodule;

import android.content.Context;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/29 15:59
 * Description:类描述
 */
public abstract class BasePlayer implements IMediaPlayer {
    protected Context mContext;
    protected IOnPreparedListener mOnPreparedListener;
    protected IOnErrorListener mOnErrorListener;
    protected IOnCompleteListener mOnCompleteListener;

    public BasePlayer(Context context) {
        mContext = context;
    }

    @Override
    public void setOnPreparedListener(IOnPreparedListener onPreparedListener) {
        mOnPreparedListener = onPreparedListener;
    }

    @Override
    public void setOnErrorListener(IOnErrorListener onErrorListener) {
        mOnErrorListener = onErrorListener;
    }

    @Override
    public void setOnCompleteListener(IOnCompleteListener onCompleteListener) {
        mOnCompleteListener = onCompleteListener;
    }
}
