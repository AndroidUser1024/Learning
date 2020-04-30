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
    protected IMediaPlayerListener mMediaPlayerListener;

    public BasePlayer(Context context) {
        mContext = context;
    }

    @Override
    public void setMediaPlayerListener(IMediaPlayerListener mediaPlayerListener) {
        mMediaPlayerListener = mediaPlayerListener;
    }

}
