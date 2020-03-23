package com.qinshou.qinshoubox.im.bean;


import com.jeejio.dbmodule.annotation.Column;
import com.jeejio.dbmodule.annotation.Id;
import com.jeejio.dbmodule.annotation.Table;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/04 23:05
 * Description:群实体类
 */
@Table(name = "group_chat")
public class GroupChatBean {
    /**
     * Id
     */
    @Id
    @Column
    private String id;
    /**
     * 群主 Id
     */
    @Column
    private String ownerId;
    /**
     * 昵称
     */
    @Column
    private String nickname;
    /**
     * 头像
     */
    @Column
    private String headImg;
    /**
     * 头像,缩略图
     */
    @Column
    private String headImgSmall;
    /**
     * 默认群昵称,由前 5 个群成员的昵称拼接起来的字符串
     */
    @Column
    private String nicknameDefault;
    /**
     * 在本群中的昵称
     */
    @Column
    private String nicknameInGroupChat;
    /**
     * 群聊会话是否置顶,1 为置顶,0 为不置顶
     */
    @Column(type = Column.Type.INTEGER)
    private int top;
    /**
     * 群聊会话是否免打扰,1 为免打扰,0 为非免打扰
     */
    @Column(type = Column.Type.INTEGER)
    private int doNotDisturb;
    /**
     * 群聊会话是否显示成员昵称,1 为显示,0 为不显示
     */
    @Column(type = Column.Type.INTEGER)
    private int showGroupChatMemberNickname;
    /**
     * 群成员个数
     */
    @Column(type = Column.Type.INTEGER)
    private int memberCount;

    public GroupChatBean() {
    }

    public GroupChatBean(String id, String ownerId, String nickname, String headImg, String headImgSmall, String nicknameDefault, String nicknameInGroupChat, int top, int doNotDisturb, int showGroupChatMemberNickname, int memberCount) {
        this.id = id;
        this.ownerId = ownerId;
        this.nickname = nickname;
        this.headImg = headImg;
        this.headImgSmall = headImgSmall;
        this.nicknameDefault = nicknameDefault;
        this.nicknameInGroupChat = nicknameInGroupChat;
        this.top = top;
        this.doNotDisturb = doNotDisturb;
        this.showGroupChatMemberNickname = showGroupChatMemberNickname;
        this.memberCount = memberCount;
    }

    @Override
    public String toString() {
        return "GroupChatBean{" +
                "id='" + id + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headImg='" + headImg + '\'' +
                ", headImgSmall='" + headImgSmall + '\'' +
                ", nicknameDefault='" + nicknameDefault + '\'' +
                ", nicknameInGroupChat='" + nicknameInGroupChat + '\'' +
                ", top=" + top +
                ", doNotDisturb=" + doNotDisturb +
                ", showGroupChatMemberNickname=" + showGroupChatMemberNickname +
                ", memberCount=" + memberCount +
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

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }
}
