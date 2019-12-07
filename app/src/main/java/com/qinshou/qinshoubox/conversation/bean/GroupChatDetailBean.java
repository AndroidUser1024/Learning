package com.qinshou.qinshoubox.conversation.bean;

import com.qinshou.qinshoubox.friend.bean.UserDetailBean;

import java.util.List;

/**
 * Description:群详情映射实体类
 * Author: QinHao
 * Date: 2019/11/21 22:13
 */
public class GroupChatDetailBean {
    /**
     * Id
     */
    private String id;
    /**
     * 群主 Id
     */
    private String ownerId;
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
     * 默认群昵称,由前 5 个群成员的昵称拼接起来的字符串
     */
    private String nicknameDefault;
    /**
     * 群成员,前 15 个
     */
    private List<UserDetailBean> memberList;
    /**
     * 在本群中的昵称
     */
    private String nicknameInGroupChat;
    /**
     * 群聊会话是否置顶,1 为置顶,0 为不置顶
     */
    private int top;
    /**
     * 群聊会话是否免打扰,1 为免打扰,0 为非免打扰
     */
    private int doNotDisturb;
    /**
     * 群聊会话是否显示成员昵称,1 为显示,0 为不显示
     */
    private int showGroupChatMemberNickname;

    public GroupChatDetailBean() {
    }

    @Override
    public String toString() {
        return "GroupChatDetailBean{" +
                "id='" + id + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headImg='" + headImg + '\'' +
                ", headImgSmall='" + headImgSmall + '\'' +
                ", nicknameDefault='" + nicknameDefault + '\'' +
                ", memberList=" + memberList +
                ", nicknameInGroupChat='" + nicknameInGroupChat + '\'' +
                ", top=" + top +
                ", doNotDisturb=" + doNotDisturb +
                ", showGroupChatMemberNickname=" + showGroupChatMemberNickname +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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

    public String getNicknameDefault() {
        return nicknameDefault;
    }

    public void setNicknameDefault(String nicknameDefault) {
        this.nicknameDefault = nicknameDefault;
    }

    public List<UserDetailBean> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<UserDetailBean> memberList) {
        this.memberList = memberList;
    }

    public String getNicknameInGroupChat() {
        return nicknameInGroupChat;
    }

    public void setNicknameInGroupChat(String nicknameInGroupChat) {
        this.nicknameInGroupChat = nicknameInGroupChat;
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

    public int getShowGroupChatMemberNickname() {
        return showGroupChatMemberNickname;
    }

    public void setShowGroupChatMemberNickname(int showGroupChatMemberNickname) {
        this.showGroupChatMemberNickname = showGroupChatMemberNickname;
    }
}
