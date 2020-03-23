package com.qinshou.qinshoubox.im.bean;


/**
 * Description:获取用户详情接口的映射类
 * Author: QinHao
 * Date: 2019/11/19 10:11
 */
public class UserDetailBean {
    /**
     * Id
     */
    private String id;
    /**
     * 用户名
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
    private int gender;
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
     * status 表示搜索目标用户与发起搜索的用户的关系
     * 0: 非好友
     * 1: 对方是你好友,但你不是对方好友
     * 2: 你是对方好友,但对方不是你好友
     * 3: 互为好友
     * <p>
     */
    private int status;
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
    /**
     * 在群聊中的昵称
     */
    private String nicknameInGroupChat;
    /**
     * 是否在线,0 为不在线,1 为在线
     */
    private int online;
    /**
     * 最后一次退出时间
     */
    private long lastLogoutTimestamp;
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

    public UserDetailBean() {
    }

    @Override
    public String toString() {
        return "UserDetailBean{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headImg='" + headImg + '\'' +
                ", headImgSmall='" + headImgSmall + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", signature='" + signature + '\'' +
                ", gender=" + gender +
                ", source=" + source +
                ", status=" + status +
                ", receive=" + receive +
                ", remark='" + remark + '\'' +
                ", additionalMsg='" + additionalMsg + '\'' +
                ", nicknameInGroupChat='" + nicknameInGroupChat + '\'' +
                ", online=" + online +
                ", lastLogoutTimestamp=" + lastLogoutTimestamp +
                ", top=" + top +
                ", doNotDisturb=" + doNotDisturb +
                ", blackList=" + blackList +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getNicknameInGroupChat() {
        return nicknameInGroupChat;
    }

    public void setNicknameInGroupChat(String nicknameInGroupChat) {
        this.nicknameInGroupChat = nicknameInGroupChat;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public long getLastLogoutTimestamp() {
        return lastLogoutTimestamp;
    }

    public void setLastLogoutTimestamp(long lastLogoutTimestamp) {
        this.lastLogoutTimestamp = lastLogoutTimestamp;
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
