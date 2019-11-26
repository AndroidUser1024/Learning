package com.qinshou.qinshoubox.im.enums;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/27 18:11
 * Description:消息状态
 */
public enum MessageStatus {
    SENDED(1),
    RECEIVED(2),
    READED(3);

    private int value;

    MessageStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
