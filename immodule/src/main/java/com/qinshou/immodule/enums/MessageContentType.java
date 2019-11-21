package com.qinshou.immodule.enums;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/27 18:07
 * Description:消息内容类型
 */
public enum MessageContentType {
    SYSTEM(1),
    TEXT(2),
    IMAGE(3),
    VOICE(4);

    private int value;

    MessageContentType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
