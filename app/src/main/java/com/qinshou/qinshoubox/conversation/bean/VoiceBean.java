package com.qinshou.qinshoubox.conversation.bean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/9 18:01
 * Description:语音类型的消息的扩展字段
 */
public class VoiceBean {
    private String path;
    private String url;
    private long time;

    public VoiceBean(String path, long time) {
        this.path = path;
        this.time = time;
    }

    @Override
    public String toString() {
        return "VoiceBean{" +
                "path='" + path + '\'' +
                ", url='" + url + '\'' +
                ", time=" + time +
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
