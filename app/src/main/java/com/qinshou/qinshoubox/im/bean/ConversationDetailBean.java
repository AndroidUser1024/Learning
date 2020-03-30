package com.qinshou.qinshoubox.im.bean;

import android.text.TextUtils;

import com.qinshou.qinshoubox.im.enums.MessageType;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/30 14:27
 * Description:会话详情实体类
 */
public class ConversationDetailBean {
    /**
     * 自增长 id
     */
    private int id;
    /**
     * 未读数
     */
    private int unreadCount;
    /**
     * 会话类型
     */
    private int type;
    /**
     * 私聊就是对方的用户 id,群聊就是群的 id
     */
    private String toUserId;
    /**
     * 最后一条消息的时间
     */
    private long lastMsgTimestamp;
    /**
     * 最后一条消息的 pid
     */
    private int lastMsgPid;
    /**
     * 会话小头像
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
     * 最后一条消息的内容类型
     */
    private int lastMsgContentType;
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

    // 以下是查询数据库时的列名映射字段,外部不用知道
    private String uNickname;
    private String uHeadImgSmall;
    private String fRemark;
    private int fTop;
    private int fDoNotDisturb;
    private String gcNickname;
    private String gcHeadImgSmall;
    private String gcNicknameDefault;
    private int gcTop;
    private int gcDoNotDisturb;

    public ConversationDetailBean() {
    }

    @Override
    public String toString() {
        return "ConversationDetailBean{" +
                "id=" + id +
                ", unreadCount=" + unreadCount +
                ", type=" + type +
                ", toUserId='" + toUserId + '\'' +
                ", lastMsgTimestamp=" + lastMsgTimestamp +
                ", lastMsgPid=" + lastMsgPid +
                ", headImgSmall='" + getHeadImgSmall() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", lastMsgContent='" + lastMsgContent + '\'' +
                ", lastMsgContentType=" + lastMsgContentType +
                ", top=" + getTop() +
                ", doNotDisturb=" + getDoNotDisturb() +
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

    public String getHeadImgSmall() {
        if (type == MessageType.CHAT.getValue()) {
            headImgSmall = uHeadImgSmall;
        } else if (type == MessageType.GROUP_CHAT.getValue()) {
            headImgSmall = gcHeadImgSmall;
        }
        return headImgSmall;
    }

    public void setHeadImgSmall(String headImgSmall) {
        this.headImgSmall = headImgSmall;
    }

    public String getTitle() {
        if (type == MessageType.CHAT.getValue()) {
            if (TextUtils.isEmpty(fRemark)) {
                title = uNickname;
            } else {
                title = fRemark;
            }
        } else if (type == MessageType.GROUP_CHAT.getValue()) {
            if (TextUtils.isEmpty(gcNickname)) {
                title = gcNicknameDefault;
            } else {
                title = gcNickname;
            }
        }
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

    public int getTop() {
        if (type == MessageType.CHAT.getValue()) {
            top = fTop;
        } else if (type == MessageType.GROUP_CHAT.getValue()) {
            top = gcTop;
        }
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getDoNotDisturb() {
        if (type == MessageType.CHAT.getValue()) {
            doNotDisturb = fDoNotDisturb;
        } else if (type == MessageType.GROUP_CHAT.getValue()) {
            doNotDisturb = gcDoNotDisturb;
        }
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
