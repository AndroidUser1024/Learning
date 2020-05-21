package com.qinshou.im;

import android.util.Log;

import com.qinshou.im.enums.ReconnectStrategy;
import com.qinshou.im.handler.HeartBeatHandler;
import com.qinshou.im.handler.IMClientHandler;
import com.qinshou.im.protobuf.MessageProtobuf;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/21 12:51
 * Description:类描述
 */
public enum IMClient {
    SINGLETON;

    private final String TAG = getClass().getSimpleName();
    private final long HEART_BEAT_INTERVAL = 10;
    private Channel mChannel;
    private String mHost = "10.11.11.179";
    private int mPort = 8888;
    /**
     * 执行延时任务的线程池
     */
    private ScheduledExecutorService mScheduledExecutorService = Executors.newSingleThreadScheduledExecutor(
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("Reconnect");
                    thread.setDaemon(true);
                    return thread;
                }
            });
    /**
     * 重连任务
     */
    private ScheduledFuture<?> mReconnectSchedule;
    /**
     * 记录重连尝试次数
     */
    private int mCount = 0;
    /**
     * 多少 s 后开始下次重连
     */
    private long mDelay = 0;
    private ReconnectStrategy mReconnectStrategy = ReconnectStrategy.SMART;

    public void connect() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
                try {
                    ChannelFuture channelFuture = new Bootstrap().channel(NioSocketChannel.class)
                            .group(eventLoopGroup)
                            .option(ChannelOption.TCP_NODELAY, true)
                            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000 * 10)
                            .handler(new ChannelInitializer<SocketChannel>() {
                                @Override
                                protected void initChannel(SocketChannel socketChannel) throws Exception {
                                    socketChannel.pipeline()
                                            .addLast(new ProtobufVarint32FrameDecoder())
                                            .addLast(new ProtobufDecoder(MessageProtobuf.Message.getDefaultInstance()))
                                            .addLast(new ProtobufVarint32LengthFieldPrepender())
                                            .addLast(new ProtobufEncoder())
                                            // 空闲监测
                                            .addLast("IdleStateHandler", new IdleStateHandler(HEART_BEAT_INTERVAL
                                                    , HEART_BEAT_INTERVAL
                                                    , HEART_BEAT_INTERVAL
                                                    , TimeUnit.SECONDS))
                                            // 自定义心跳处理
                                            .addLast("HeartBeatHandler", new HeartBeatHandler())
                                            .addLast(new IMClientHandler());
                                }
                            })
                            .connect(mHost, mPort)
                            .sync();
                    mChannel = channelFuture.channel();
                    Log.i(TAG, "mChannel--->" + mChannel.id().asShortText());
                    mChannel.closeFuture().sync();
                } catch (InterruptedException e) {
                    Log.i("TAG", "e" + " : " + e.getMessage());
                } catch (Exception e1) {
                    Log.i(TAG, "e1--->" + e1);
                    if (e1 instanceof ConnectTimeoutException) {
                        Log.i(TAG, "ignore ConnectTimeoutException");
                    }
                } finally {
                    Log.i("daolema", "退出了");
                    eventLoopGroup.shutdownGracefully();
                    if (mReconnectSchedule != null) {
                        mReconnectSchedule.cancel(true);
                        mReconnectSchedule = null;
                    }
                    if (mReconnectStrategy == ReconnectStrategy.FIXED) {
                        mDelay = 10;
                    } else {
                        if (mCount < 10) {
                            mDelay += 1;
                        } else if (mCount < 20) {
                            mDelay = 30;
                        } else {
                            mDelay = 60;
                        }
                    }
                    Log.i(TAG, mDelay + "s 后重连");
                    mScheduledExecutorService.schedule(new Runnable() {
                        @Override
                        public void run() {
                            connect();
                        }
                    }, mDelay, TimeUnit.SECONDS);
                }
            }
        }).start();
    }

    public void disconnect() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mChannel.close();
            }
        }).start();
    }

    public void sendMessage(MessageProtobuf.Message message) {
        mChannel.writeAndFlush(message);
    }
}
