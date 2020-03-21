package com.qinshou.qinshoubox.im.bean;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/11/21 12:52
 * Description:好友状态事件监听的映射类
 */
public class FriendStatusBean {
    private int status;
    private boolean newFriend;
    private UserDetailBean fromUser;

    public FriendStatusBean() {
    }

    @Override
    public String toString() {
        return "FriendStatusBean{" +
                "status=" + status +
                ", newFriend=" + newFriend +
                ", fromUser=" + fromUser +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isNewFriend() {
        return newFriend;
    }

    public void setNewFriend(boolean newFriend) {
        this.newFriend = newFriend;
    }

    public UserDetailBean getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserDetailBean fromUser) {
        this.fromUser = fromUser;
    }
}
