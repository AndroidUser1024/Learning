package com.qinshou.immodule.bean;


/**
 * Description:类描述
 * Author: QinHao
 * Date: 2019/11/15 16:00
 */
public class MessageIndexBean {
    private Integer id;
    /**
     * 索引查询方的用户 Id
     */
    private String fromUserId;
    /**
     * 索引另一方的用户 Id
     */
    private String toUserId;
    /**
     * 发送的消息还是收到的消息
     */
    private Integer indexType;
    /**
     * 消息的 Id
     */
    private String messageId;

    public MessageIndexBean() {
    }

    @Override
    public String toString() {
        return "MessageIndexBean{" +
                "fromUserId='" + fromUserId + '\'' +
                ", toUserId='" + toUserId + '\'' +
                ", indexType=" + indexType +
                ", messageId='" + messageId + '\'' +
                '}';
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public int getIndexType() {
        return indexType;
    }

    public void setIndexType(int indexType) {
        this.indexType = indexType;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
