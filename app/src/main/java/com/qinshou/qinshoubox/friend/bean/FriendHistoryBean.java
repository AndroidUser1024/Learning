package com.qinshou.qinshoubox.friend.bean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/9/4 9:06
 * Description:好友申请历史实体类
 */
public class FriendHistoryBean {
    /**
     * 附加消息
     */
    private String additionalMsg;
    /**
     * 好友关系状态
     */
    private Integer status;
    /**
     * 发起申请的人的 id
     */
    private String fromUserId;
    /**
     * 发起申请的人的备注
     */
    private String remark;
    /**
     * 发起申请的人的昵称
     */
    private String nickname;
    /**
     * 发起申请的人的头像
     */
    private String headImg;
    /**
     * 发起申请的人的头像,小
     */
    private String headImgSmall;

    public FriendHistoryBean() {
    }

    @Override
    public String toString() {
        return "FriendHistoryBean{" +
                "additionalMsg='" + additionalMsg + '\'' +
                ", status=" + status +
                ", fromUserId=" + fromUserId +
                ", remark=" + remark +
                ", nickname='" + nickname + '\'' +
                ", headImg='" + headImg + '\'' +
                ", headImgSmall='" + headImgSmall + '\'' +
                '}';
    }

    public String getAdditionalMsg() {
        return additionalMsg;
    }

    public void setAdditionalMsg(String additionalMsg) {
        this.additionalMsg = additionalMsg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getHeadImgSmall() {
        return headImgSmall;
    }

    public void setHeadImgSmall(String headImgSmall) {
        this.headImgSmall = headImgSmall;
    }
}
