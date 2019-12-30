package com.qinshou.qinshoubox.conversation.bean;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2019/12/30 15:53
 * Description:上传语音文件结果映射类
 */
public class UploadVoiceResultBean extends UploadResultBean {
    private String path;
    private long time;

    public UploadVoiceResultBean() {
    }

    @Override
    public String toString() {
        return "UploadVoiceResultBean{" +
                ", path='" + path + '\'' +
                ", time=" + time +
                '}';
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
}
