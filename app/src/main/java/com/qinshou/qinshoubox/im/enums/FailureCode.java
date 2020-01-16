package com.qinshou.qinshoubox.im.enums;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2019/12/26 18:59
 * Description:错误信息
 */
public enum FailureCode {
    NOT_FRIEND(400, "对方不是您的好友"),
    NOT_IN_GROUP_CHAT(401, "您不在该群聊中");
    private int value;
    private String desc;

    FailureCode(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }
}
