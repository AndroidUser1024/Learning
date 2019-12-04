package com.qinshou.immodule.bean;


/**
 * Description:好友映射类
 * Author: QinHao
 * Date: 2019/11/20 10:50
 */
public class FriendBean {
    /**I
     * 好友的 id
     */
    private int id;
    /**
     * 好友的用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 小头像
     */
    private String headImgSmall;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否置顶,0 是非置顶,1 是置顶
     */
    private int top;
    /**
     * 是否免打扰,0 是非免打扰,1 是免打扰
     */
    private int doNotDisturb;
    /**
     * 是否加入了黑名单,0 是没有加入,1 是加入了
     */
    private int blackList;

    public FriendBean() {
    }

    @Override
    public String toString() {
        return "FriendBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headImg='" + headImg + '\'' +
                ", headImgSmall='" + headImgSmall + '\'' +
                ", signature='" + signature + '\'' +
                ", remark='" + remark + '\'' +
                ", top=" + top +
                ", doNotDisturb=" + doNotDisturb +
                ", blackList=" + blackList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public int getBlackList() {
        return blackList;
    }

    public void setBlackList(int blackList) {
        this.blackList = blackList;
    }
}