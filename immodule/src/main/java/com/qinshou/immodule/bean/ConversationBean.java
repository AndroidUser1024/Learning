package com.qinshou.immodule.bean;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.qinshou.immodule.bean.MessageBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/2 9:55
 * Description:会话实体类
 */
@DatabaseTable(tableName = "conversation")
public class ConversationBean {
    /**
     * 自增长 Id
     */
    @DatabaseField(columnName = "id", generatedId = true)
    private int id;
    /**
     * 私聊就是对方的用户 id,群聊就是群的 id
     */
    @DatabaseField(columnName = "toUserId")
    private int toUserId;
    /**
     * 会话类型
     */
    @DatabaseField(columnName = "type")
    private int type;
    /**
     * 最后一条消息的内容
     */
    @DatabaseField(columnName = "lastMsgContent")
    private String lastMsgContent;
    /**
     * 最后一条消息的类型
     */
    @DatabaseField(columnName = "lastMsgContentType")
    private int lastMsgContentType;
    /**
     * 最后一条消息的时间
     */
    @DatabaseField(columnName = "lastMsgTime")
    private long lastMsgTime;
    /**
     * 未读数
     */
    @DatabaseField(columnName = "unreadCount")
    private int unreadCount;

    public ConversationBean() {
    }

    public ConversationBean(int toUserId, int type, String lastMsgContent, int lastMsgContentType, long lastMsgTime, int unreadCount) {
        this.toUserId = toUserId;
        this.type = type;
        this.lastMsgContent = lastMsgContent;
        this.lastMsgContentType = lastMsgContentType;
        this.lastMsgTime = lastMsgTime;
        this.unreadCount = unreadCount;
    }

    @Override
    public String toString() {
        return "ConversationBean{" +
                "id=" + id +
                ", toUserId=" + toUserId +
                ", type=" + type +
                ", lastMsgContent='" + lastMsgContent + '\'' +
                ", lastMsgContentType=" + lastMsgContentType +
                ", lastMsgTime=" + lastMsgTime +
                ", unreadCount=" + unreadCount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLastMsgContent() {
        return lastMsgContent;
    }

    public void setLastMsgContent(String lastMsgContent) {
        this.lastMsgContent = lastMsgContent;
    }

    public int getLastMsgContentType() {
        return lastMsgContentType;
    }

    public void setLastMsgContentType(int lastMsgContentType) {
        this.lastMsgContentType = lastMsgContentType;
    }

    public long getLastMsgTime() {
        return lastMsgTime;
    }

    public void setLastMsgTime(long lastMsgTime) {
        this.lastMsgTime = lastMsgTime;
    }


    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }
}
