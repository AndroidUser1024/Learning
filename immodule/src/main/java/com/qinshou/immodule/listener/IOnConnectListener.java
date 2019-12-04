package com.qinshou.immodule.listener;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/4 19:45
 * Description:连接 WebSocket 监听器
 */
public interface IOnConnectListener {
    void onConnected();

    void onAuthenticated();

    void onConnectFailure(Exception e);

    void onDisconnected();
}
