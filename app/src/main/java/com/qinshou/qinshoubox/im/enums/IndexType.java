package com.qinshou.qinshoubox.im.enums;

/**
 * Description:类描述
 * Author: QinHao
 * Date: 2019/11/15 16:06
 */
public enum IndexType {
    /**
     * 发送的消息
     */
    SEND(1),
    /**
     * 收到的消息
     */
    RECEIVE(2);
    private int value;

    IndexType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
