package com.qinshou.qinshoubox.conversation.bean;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2019/12/30 17:51
 * Description:上传文件结果映射类
 */
public class UploadResultBean {
    private String url;

    @Override
    public String toString() {
        return "UploadResultBean{" +
                "url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
