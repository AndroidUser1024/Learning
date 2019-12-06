package com.qinshou.qinshoubox.im.enums;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/6 21:01
 * Description:好友关系
 */
public enum FriendRelStatus {
    /**
     * 非好友
     */
    NONE(0),

    /**
     * 对方是你好友,但你不是对方好友
     */
    TO(1),

    /**
     * 你是对方好友,但对方不是你好友
     */
    FROM(2),

    /**
     * 互为好友
     */
    BOTH(3);

    private int value;

    FriendRelStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
