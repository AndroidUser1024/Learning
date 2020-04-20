package com.qinshou.qinshoubox.im.bean;

import com.qinshou.dbmodule.annotation.Column;
import com.qinshou.dbmodule.annotation.Id;
import com.qinshou.dbmodule.annotation.Table;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-3-21 下午3:58
 * Description:
 */
@Table(name = "user")
public class UserBean {
    /**
     * Id
     */
    @Id
    @Column
    private String id;
    /**
     * 用户名
     */
    @Column
    private String username;
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

    public UserBean() {
    }

    public UserBean(String id, String username, String nickname, String headImg, String headImgSmall) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.headImg = headImg;
        this.headImgSmall = headImgSmall;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headImg='" + headImg + '\'' +
                ", headImgSmall='" + headImgSmall + '\'' +
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
}
