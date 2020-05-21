package com.qinshou.im.enums;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/21 15:07
 * Description:类描述
 */
public enum MessageType {
    HANDSHAKE(1001),
    HANDSHAKE_SUCCESS(1002),
    HEART_BEAT(1003),
    HEART_BEAT_RECEIPT(1004);

    private int value;

    MessageType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
