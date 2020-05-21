package com.qinshou.im.handler;

import android.util.Log;

import com.qinshou.im.enums.MessageType;
import com.qinshou.im.protobuf.MessageProtobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;


/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2019/12/1 9:50
 * Description:心跳处理者
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {
    private final String TAG = getClass().getSimpleName();

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        if (evt instanceof IdleStateEvent) {
            if (((IdleStateEvent) evt).state() == IdleState.READER_IDLE) {
                Log.i(TAG, ctx.channel().id().asShortText() + " 读空闲");
            } else if (((IdleStateEvent) evt).state() == IdleState.WRITER_IDLE) {
                Log.i(TAG, ctx.channel().id().asShortText() + " 写空闲");
            } else if (((IdleStateEvent) evt).state() == IdleState.ALL_IDLE) {
                Log.i(TAG, ctx.channel().id().asShortText() + " 读写空闲");
                ctx.channel().writeAndFlush(MessageProtobuf.Message.newBuilder()
                        .setType(MessageType.HEART_BEAT.getValue())
                        .build());
            }
        }
    }
}
