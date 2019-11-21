package com.qinshou.immodule.enums;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/27 18:11
 * Description:消息状态
 */
public enum MessageStatus {
    SENDING(1),
    SENDED(2),
    RECEIVING(3),
    RECEIVED(4);

    private int value;

    MessageStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
