package com.qinshou.qinshoubox.im.bean;


import com.qinshou.dbmodule.annotation.Column;
import com.qinshou.dbmodule.annotation.Id;
import com.qinshou.dbmodule.annotation.Table;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/04 23:04
 * Description:会话实体类
 */
@Table(name = "conversation")
public class ConversationBean {
    /**
     * 自增长 Id
     */
    @Id(autoIncrement = true, useGeneratedKeys = true)
    @Column(type = Column.Type.INTEGER)
    private int id;
    /**
     * 未读数
     */
    @Column(type = Column.Type.INTEGER)
    private int unreadCount;
    /**
     * 会话类型
     */
    @Column(type = Column.Type.INTEGER)
    private int type;
    /**
     * 私聊就是对方的用户 id,群聊就是群的 id
     */
    @Column
    private String toUserId;
    /**
     * 最后一条消息的时间
     */
    @Column(type = Column.Type.LONG)
    private long lastMsgTimestamp;
    /**
     * 最后一条消息的 pid
     */
    @Column(type = Column.Type.INTEGER)
    private int lastMsgPid;

    public ConversationBean() {
    }

    public ConversationBean(int unreadCount, int type, String toUserId, long lastMsgTimestamp, int lastMsgPid) {
        this.unreadCount = unreadCount;
        this.type = type;
        this.toUserId = toUserId;
        this.lastMsgTimestamp = lastMsgTimestamp;
        this.lastMsgPid = lastMsgPid;
    }

    @Override
    public String toString() {
        return "ConversationBean{" +
                "id=" + id +
                ", unreadCount=" + unreadCount +
                ", type=" + type +
                ", toUserId='" + toUserId + '\'' +
                ", lastMsgTimestamp=" + lastMsgTimestamp +
                ", lastMsgPid=" + lastMsgPid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public long getLastMsgTimestamp() {
        return lastMsgTimestamp;
    }

    public void setLastMsgTimestamp(long lastMsgTimestamp) {
        this.lastMsgTimestamp = lastMsgTimestamp;
    }

    public int getLastMsgPid() {
        return lastMsgPid;
    }

    public void setLastMsgPid(int lastMsgPid) {
        this.lastMsgPid = lastMsgPid;
    }
}
