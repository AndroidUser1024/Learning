package com.qinshou.qinshoubox.conversation.bean;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2020/1/1 15:17
 * Description:上传图片结果映射类
 */
public class UploadImgResultBean extends UploadResultBean {
    private String path;
    private String smallUrl;

    public UploadImgResultBean() {
    }

    @Override
    public String toString() {
        return "UploadVoiceResultBean{" +
                ", path='" + path + '\'' +
                ", smallUrl=" + smallUrl +
                '}';
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
