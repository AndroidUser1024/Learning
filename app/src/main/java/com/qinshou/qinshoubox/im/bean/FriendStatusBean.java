package com.qinshou.qinshoubox.im.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/11/21 12:52
 * Description:好友状态事件监听的映射类
 */
public class FriendStatusBean {
    private int status;
    private boolean newFriend;
    @SerializedName("fromUser")
    private UserDetailBean mUserDetailBean;

    public FriendStatusBean() {
    }

    @Override
    public String toString() {
        return "FriendStatusBean{" +
                "status=" + status +
                ", newFriend=" + newFriend +
                ", mUserDetailBean=" + mUserDetailBean +
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

    public UserDetailBean getUserDetailBean() {
        return mUserDetailBean;
    }

    public void setUserDetailBean(UserDetailBean userDetailBean) {
        mUserDetailBean = userDetailBean;
    }
}
