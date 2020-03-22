package com.qinshou.qinshoubox.im.bean;


import com.jeejio.dbmodule.annotation.Column;
import com.jeejio.dbmodule.annotation.Id;
import com.jeejio.dbmodule.annotation.Table;

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
    @Id(autoIncrement = true)
    @Column(type = Column.Type.INTEGER)
    private int id;
    /**
     * 未读数
     */
    @Column(type = Column.Type.INTEGER)
    private int unreadCount;
    /**
     * 私聊就是对方的用户 id,群聊就是群的 id
     */
    @Column
    private String toUserId;
    /**
     * 会话类型
     */
    @Column(type = Column.Type.INTEGER)
    private int type;
    /**
     * 对方的小头像
     */
    private String headImgSmall;
    /**
     * 会话标题
     */
    private String title;
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
     * 是否置顶,0 是非置顶,1 是置顶
     */
    private int top;
    /**
     * 是否免打扰,0 是非免打扰,1 是免打扰
     */
    private int doNotDisturb;
    /**
     * 最后一条消息发送状态 -1 发送失败   0 发送中    1 发送成功
     */
    private int lastMsgStatus;

    public ConversationBean() {
    }

    @Override
    public String toString() {
        return "ConversationBean{" +
                "id=" + id +
                ", unreadCount=" + unreadCount +
                ", toUserId='" + toUserId + '\'' +
                ", type=" + type +
                ", headImgSmall='" + headImgSmall + '\'' +
                ", title='" + title + '\'' +
                ", lastMsgContent='" + lastMsgContent + '\'' +
                ", lastMsgContentType=" + lastMsgContentType +
                ", lastMsgTimestamp=" + lastMsgTimestamp +
                ", top=" + top +
                ", doNotDisturb=" + doNotDisturb +
                ", lastMsgStatus=" + lastMsgStatus +
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

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getDoNotDisturb() {
        return doNotDisturb;
    }

    public void setDoNotDisturb(int doNotDisturb) {
        this.doNotDisturb = doNotDisturb;
    }

    public int getLastMsgStatus() {
        return lastMsgStatus;
    }

    public void setLastMsgStatus(int lastMsgStatus) {
        this.lastMsgStatus = lastMsgStatus;
    }
}
