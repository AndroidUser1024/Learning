package com.qinshou.immodule.enums;

/**
 * Description:类描述
 * Author: QinHao
 * Date: 2019/11/21 10:32
 */
public enum FriendStatus {
    /**
     * 添加好友
     */
    ADD(1),
    /**
     * 同意添加好友
     */
    AGREE_ADD(2),
    /**
     * 拒绝添加
     */
    REFUSE_ADD(3),
    /**
     * 删除好友
     */
    DELETE(4),
    /**
     * 好友上线
     */
    ONLINE(5),
    /**
     * 好友下线
     */
    OFFLINE(6);
    private int value;

    FriendStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
