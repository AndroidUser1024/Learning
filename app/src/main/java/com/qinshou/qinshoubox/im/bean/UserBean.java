package com.qinshou.qinshoubox.im.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/26 9:33
 * Description:用户实体类
 */
public class UserBean {
    /**
     * Id
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 头像,缩略图
     */
    private String headImgSmall;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 性别,1 是男,2 是女
     */
    private Integer gender;
    /**
     * 搜索目标用户与发起搜索的用户的关系
     * 0 互相不为好友或对方不是你好友
     * 1 互为好友或对方是你好友
     */
    private int friendStatus;
    /**
     * 用户来源
     * 当关系为非好友时,该字段表示搜索来源
     * 1 通过用户名搜索到的
     * 2 通过手机号搜索到的
     * 3 通过邮箱搜索到的
     * 当关系为好友或等待接受对方的好友请求时,该字段表示好友来源
     * 1 通过用户名添加
     * 2 通过手机号添加
     * 3 通过邮箱添加
     * 4 通过扫一扫添加
     * 5 通过群聊添加
     * -1 对方通过用户名添加
     * -2 对方通过手机号添加
     * -3 对方通过邮箱添加
     * -4 对方通过扫一扫添加
     * -5 对方通过群聊添加
     */
    private int source;
    /**
     * 是否有收到添加好友的请求
     */
    private int receive;
    /**
     * 备注
     */
    private String remark;
    /**
     * 好友申请的附加信息
     */
    private String additionalMsg;

    public UserBean() {
    }

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headImg='" + headImg + '\'' +
                ", headImgSmall='" + headImgSmall + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", signature='" + signature + '\'' +
                ", gender='" + gender + '\'' +
                ", friendStatus=" + friendStatus +
                ", source=" + source +
                ", receive=" + receive +
                ", remark='" + remark + '\'' +
                ", additionalMsg='" + additionalMsg + '\'' +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public int getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(int friendStatus) {
        this.friendStatus = friendStatus;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getReceive() {
        return receive;
    }

    public void setReceive(int receive) {
        this.receive = receive;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAdditionalMsg() {
        return additionalMsg;
    }

    public void setAdditionalMsg(String additionalMsg) {
        this.additionalMsg = additionalMsg;
    }
}
