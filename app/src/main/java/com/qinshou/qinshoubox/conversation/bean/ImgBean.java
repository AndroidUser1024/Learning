package com.qinshou.qinshoubox.conversation.bean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/1 15:17
 * Description:图片类型的消息的扩展字段
 */
public class ImgBean {
    private String path;
    private String url;
    private String smallUrl;

    public ImgBean() {
    }

    public ImgBean(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ImgBean{" +
                "path='" + path + '\'' +
                ", url='" + url + '\'' +
                ", smallUrl='" + smallUrl + '\'' +
                '}';
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

}
