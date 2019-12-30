package com.qinshou.qinshoubox.conversation.bean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/9 18:01
 * Description:语音类型的消息的扩展字段
 */
public class VoiceBean {
    private String url;
    private String path;
    private long time;
    /**
     * 是否未播放过,0 为未播放过,1 为已播放过
     */
    private int unread;


    public VoiceBean(String url, String path, long time) {
        this.url = url;
        this.path = path;
        this.time = time;
    }

    @Override
    public String toString() {
        return "VoiceBean{" +
                "url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", time=" + time +
                ", unread=" + unread +
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }
}
