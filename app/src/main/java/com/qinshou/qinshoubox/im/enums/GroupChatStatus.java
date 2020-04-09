package com.qinshou.qinshoubox.im.enums;

/**
 * Description:群状态
 * Author: QinHao
 * Date: 2019/12/07 00:41
 */
public enum GroupChatStatus {
    /**
     * 被邀请
     */
    ADD(40001),
    /**
     * 被踢出
     */
    DELETE(40002),
    /**
     * 别人被邀请
     */
    OTHER_ADD(40003),
    /**
     * 别人被踢出
     */
    OTHER_DELETE(40004),
    /**
     * 群昵称被修改
     */
    NICKNAME_CHANGED(40005),
    /**
     * 有人修改了他在本群中的群昵称
     */
    NICKNAME_IN_GROUP_CHAT_CHANGED(40006);
    private int value;

    GroupChatStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GroupChatStatus getByValue(int value) {
        for (GroupChatStatus groupChatStatus : values()) {
            if (groupChatStatus.value == value) {
                return groupChatStatus;
            }
        }
        return null;
    }
}
