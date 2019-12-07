package com.qinshou.qinshoubox.homepage.bean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/26 12:56
 * Description:发送事件
 */
public class EventBean<T> {
    private Type mType;
    private T mData;

    public EventBean(Type type, T data) {
        mType = type;
        mData = data;
    }

    @Override
    public String toString() {
        return "EventBean{" +
                "mType=" + mType +
                ", mData=" + mData +
                '}';
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }

    public enum Type {
        LOGIN,
        LOGOUT,
        REFRESH_USER_BEAN,
        REFRESH_GROUP_CHAT_LIST,
        REFRESH_FRIEND_LIST,
        REFRESH_CONVERSATION_LIST,
        REFRESH_GROUP_CHAT_MEMBER_LIST,
    }
}
