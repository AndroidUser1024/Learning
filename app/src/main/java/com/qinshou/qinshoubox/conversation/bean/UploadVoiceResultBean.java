package com.qinshou.qinshoubox.conversation.bean;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2019/12/30 15:53
 * Description:上传语音结果映射类
 */
public class UploadVoiceResultBean extends UploadResultBean {
    private long time;

    public UploadVoiceResultBean() {
    }

    @Override
    public String toString() {
        return "UploadVoiceResultBean{" +
                ", time=" + time +
                '}';
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
