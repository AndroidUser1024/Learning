package com.qinshou.immodule.bean;



/**
 * Description:群实体类
 * Author: QinHao
 * Date: 2019/11/21 22:13
 */
public class GroupChatBean {
    /**
     * Id
     */
    private Integer id;
    /**
     * 群主 Id
     */
    private Integer ownerId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 默认群昵称,由前 5 个群成员的昵称拼接起来的字符串
     */
    private String nicknameDefault;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 头像,缩略图
     */
    private String headImgSmall;
//    /**
//     * 群成员,前 15 个
//     */
//    private List<UserBean> memberList;

    public GroupChatBean() {
    }

    @Override
    public String toString() {
        return "GroupChatBean{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", nickname='" + nickname + '\'' +
                ", nicknameDefault='" + nicknameDefault + '\'' +
                ", headImg='" + headImg + '\'' +
                ", headImgSmall='" + headImgSmall + '\'' +
//                ", memberList='" + memberList + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNicknameDefault() {
        return nicknameDefault;
    }

    public void setNicknameDefault(String nicknameDefault) {
        this.nicknameDefault = nicknameDefault;
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

//    public List<UserBean> getMemberList() {
//        return memberList;
//    }
//
//    public void setMemberList(List<UserBean> memberList) {
//        this.memberList = memberList;
//    }
}
