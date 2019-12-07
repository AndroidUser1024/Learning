package com.qinshou.qinshoubox.im.enums;

/**
 * Description:群状态
 * Author: QinHao
 * Date: 2019/12/07 00:41
 */
public enum  GroupChatStatus {
    /**
     * 被邀请
     */
    ADD(1),
    /**
     * 被踢出
     */
    DELETE(2),
    /**
     * 别人被邀请
     */
    OTHER_ADD(3),
    /**
     * 别人被踢出
     */
    OTHER_DELETE(4);
    private int value;

    GroupChatStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
