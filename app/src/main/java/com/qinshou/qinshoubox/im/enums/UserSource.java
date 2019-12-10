package com.qinshou.qinshoubox.im.enums;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/10 9:39
 * Description:用户来源
 */
public enum UserSource {
    SEARCH_BY_USERNAME(1, "通过用户名搜索"),
    SEARCH_BY_PHONE_NUMBER(2, "通过手机号搜索"),
    SEARCH_BY_EMAIL(3, "通过邮箱搜索");
    private int value;
    private String desc;

    UserSource(int value, String desc) {
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

    public static UserSource getByValue(int value) {
        for (UserSource userSource : values()) {
            if (userSource.value == value) {
                return userSource;
            }
        }
        return null;
    }
}
