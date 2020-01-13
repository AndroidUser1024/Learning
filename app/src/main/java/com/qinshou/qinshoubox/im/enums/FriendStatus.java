package com.qinshou.qinshoubox.im.enums;

/**
 * Description:类描述
 * Author: QinHao
 * Date: 2019/11/21 10:32
 */
public enum FriendStatus {
    /**
     * 添加好友
     */
    ADD(30001),
    /**
     * 同意添加好友
     */
    AGREE_ADD(30002),
    /**
     * 拒绝添加
     */
    REFUSE_ADD(30003),
    /**
     * 删除好友
     */
    DELETE(30004),
    /**
     * 好友上线
     */
    ONLINE(30005),
    /**
     * 好友下线
     */
    OFFLINE(30006);
    private int value;

    FriendStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static FriendStatus getByValue(int value) {
        for (FriendStatus friendStatus : values()) {
            if (friendStatus.value == value) {
                return friendStatus;
            }
        }
        return null;
    }
}
