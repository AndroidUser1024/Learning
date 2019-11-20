package com.qinshou.immodule.bean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/27 18:04
 * Description:消息类型
 */
public enum MessageType {
    HANDSHAKE(1001),
    HANDSHAKE_SUCCESS(1002),
    HEART(1003),
    CLIENT_RECEIPT(1004),
    SERVER_RECEIPT(1005),
    CHAT(2001),
    GROUP_CHAT(3001);

    private int value;

    MessageType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
