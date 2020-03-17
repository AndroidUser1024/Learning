package com.qinshou.qinshoubox.im.bean;

import java.util.List;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/7 14:15
 * Description:群状态事件监听的映射类
 */
public class GroupChatStatusBean {
    /**
     * 群相关操作类型
     */
    private int status;
    /**
     * 目标群聊 id
     */
    private String groupChatId;
    /**
     * 发起该操作的人
     */
    private UserDetailBean fromUser;
    /**
     * 被操作的人的 Id 的集合
     */
    private List<UserDetailBean> toUserList;

    public GroupChatStatusBean() {
    }

    @Override
    public String toString() {
        return "GroupChatStatusBean{" +
                "status=" + status +
                ", groupChatId='" + groupChatId + '\'' +
                ", fromUser='" + fromUser + '\'' +
                ", toUserList='" + toUserList + '\'' +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getGroupChatId() {
        return groupChatId;
    }

    public void setGroupChatId(String groupChatId) {
        this.groupChatId = groupChatId;
    }

    public UserDetailBean getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserDetailBean fromUser) {
        this.fromUser = fromUser;
    }

    public List<UserDetailBean> getToUserList() {
        return toUserList;
    }

    public void setToUserList(List<UserDetailBean> toUserList) {
        this.toUserList = toUserList;
    }
}
