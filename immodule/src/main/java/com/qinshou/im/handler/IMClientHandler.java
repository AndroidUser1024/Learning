package com.qinshou.im.handler;

import android.util.Log;

import com.qinshou.im.IMClient;

import java.io.IOException;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/21 12:55
 * Description:类描述
 */
public class IMClientHandler extends ChannelInboundHandlerAdapter {
    private final String TAG = getClass().getSimpleName();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        Log.i(TAG, "channelRead--->" + msg);
    }

}
