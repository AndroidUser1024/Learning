package com.qinshou.immodule.bean;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/2 9:55
 * Description:会话实体类
 */
public class ConversationBean {
    /**
     * 自增长 Id
     */
    private int id;
    /**
     * 私聊就是对方的用户 id,群聊就是群的 id
     */
    private int toUserId;
    /**
     * 会话类型
     */
    private int type;
    /**
     * 最后一条消息的内容
     */
    private String lastMsgContent;
    /**
     * 最后一条消息的类型
     */
    private int lastMsgContentType;
    /**
     * 最后一条消息的时间
     */
    private long lastMsgTimestamp;
    /**
     * 未读数
     */
    private int unreadCount;
    /**
     * 对方的小头像
     */
    private String headImgSmall;
    /**
     * 会话标题
     */
    private String title;

    public ConversationBean() {
    }

    public ConversationBean(int toUserId, int type, String lastMsgContent, int lastMsgContentType, long lastMsgTimestamp, int unreadCount) {
        this.toUserId = toUserId;
        this.type = type;
        this.lastMsgContent = lastMsgContent;
        this.lastMsgContentType = lastMsgContentType;
        this.lastMsgTimestamp = lastMsgTimestamp;
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
                ", lastMsgTimestamp=" + lastMsgTimestamp +
                ", unreadCount=" + unreadCount +
                ", headImgSmall='" + headImgSmall + '\'' +
                ", title='" + title + '\'' +
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

    public long getLastMsgTimestamp() {
        return lastMsgTimestamp;
    }

    public void setLastMsgTimestamp(long lastMsgTimestamp) {
        this.lastMsgTimestamp = lastMsgTimestamp;
    }


    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {

        this.unreadCount = unreadCount;
    }

    public String getHeadImgSmall() {
        return headImgSmall;
    }

    public void setHeadImgSmall(String headImgSmall) {
        this.headImgSmall = headImgSmall;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
