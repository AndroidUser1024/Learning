package com.qinshou.qinshoubox.me.bean;

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
    private Long id;
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
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
