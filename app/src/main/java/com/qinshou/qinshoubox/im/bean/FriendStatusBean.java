package com.qinshou.qinshoubox.im.bean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/21 12:52
 * Description:好友状态事件监听的映射类
 */
public class FriendStatusBean {
    private int status;
    private String fromUserId;
    private String additionalMsg;
    private boolean newFriend;

    public FriendStatusBean() {
    }

    @Override
    public String toString() {
        return "FriendStatusBean{" +
                "status=" + status +
                ", fromUserId=" + fromUserId +
                ", additionalMsg='" + additionalMsg + '\'' +
                ", newFriend=" + newFriend +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getAdditionalMsg() {
        return additionalMsg;
    }

    public void setAdditionalMsg(String additionalMsg) {
        this.additionalMsg = additionalMsg;
    }

    public boolean isNewFriend() {
        return newFriend;
    }

    public void setNewFriend(boolean newFriend) {
        this.newFriend = newFriend;
    }
}
