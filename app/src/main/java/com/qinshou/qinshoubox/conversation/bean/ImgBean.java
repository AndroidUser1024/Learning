package com.qinshou.qinshoubox.conversation.bean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/1 15:17
 * Description:图片类型的消息的扩展字段
 */
public class ImgBean {
    private String url;
    private String path;
    private String smallUrl;

    public ImgBean() {
    }

    public ImgBean(String url, String path, String smallUrl) {
        this.url = url;
        this.path = path;
        this.smallUrl = smallUrl;
    }

    @Override
    public String toString() {
        return "VoiceBean{" +
                "url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", smallUrl=" + smallUrl +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

}
