package com.qinshou.qinshoubox.im.enums;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/10 9:39
 * Description:用户来源
 */
public enum FriendSource {
    ADD_BY_USERNAME(1, "通过用户名添加"),
    ADD_BY_PHONE_NUMBER(2, "通过手机号添加"),
    ADD_BY_EMAIL(3, "通过邮箱添加"),
    ADD_BY_QR_CODE(4, "通过扫一扫添加"),
    ADD_BY_GROUP_CHAT(5, "通过群聊添加"),
    ADDED_BY_USERNAME(-1, "对方通过用户名添加"),
    ADDED_BY_PHONE_NUMBER(-2, "对方通过手机号添加"),
    ADDED_BY_EMAIL(-3, "对方通过邮箱添加"),
    ADDED_BY_QR_CODE(-4, "对方通过扫一扫添加"),
    ADDED_BY_GROUP_CHAT(-5, "对方通过群聊添加");
    private int value;
    private String desc;

    FriendSource(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "UserSource{" +
                "value=" + value +
                ", desc='" + desc + '\'' +
                '}';
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static FriendSource getByValue(int value) {
        for (FriendSource userSource : values()) {
            if (userSource.value == value) {
                return userSource;
            }
        }
        return null;
    }
}
