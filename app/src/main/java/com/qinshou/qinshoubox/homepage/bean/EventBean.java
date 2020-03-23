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
        /**
         * 更新会话未读数
         */
        REFRESH_CONVERSATION_UNREAD_COUNT,
        REFRESH_GROUP_CHAT_DETAIL,
        /**
         * 更新消息列表
         */
        REFRESH_MESSAGE_LIST,
        /**
         * 更新好友申请历史未读数
         */
        REFRESH_FRIEND_HISTORY_UNREAD_COUNT,
        /**
         * 清空聊天历史
         */
        CLEAR_CHAT_HISTORY,
    }
}
