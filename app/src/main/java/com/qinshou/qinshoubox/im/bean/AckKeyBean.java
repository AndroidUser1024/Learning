package com.qinshou.qinshoubox.im.bean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/27 15:36
 * Description:ACK 机制的 key
 */
public class AckKeyBean {
    private int userId;
    private int fromUserId;
    private int toUserId;
    private int type;
    private long sendTimestamp;

    public AckKeyBean() {
    }

    public AckKeyBean(int userId, int fromUserId, int toUserId, int type, long sendTimestamp) {
        this.userId = userId;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.type = type;
        this.sendTimestamp = sendTimestamp;
    }

    @Override
    public String toString() {
        return "AckKeyBean{" +
                "userId=" + userId +
                ", fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                ", type=" + type +
                ", sendTimestamp=" + sendTimestamp +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getSendTimestamp() {
        return sendTimestamp;
    }

    public void setSendTimestamp(long sendTimestamp) {
        this.sendTimestamp = sendTimestamp;
    }
}
