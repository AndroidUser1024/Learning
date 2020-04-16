package com.qinshou.qinshoubox.me.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/9 16:51
 * Description:对话者实体类
 */
public class TalkerBean implements Parcelable {
    private String name;
    private int resourceId;
    private String[] content;

    public TalkerBean() {
    }

    public TalkerBean(String name, int resourceId, String[] content) {
        this.name = name;
        this.resourceId = resourceId;
        this.content = content;
    }

    protected TalkerBean(Parcel in) {
        name = in.readString();
        resourceId = in.readInt();
        content = in.createStringArray();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;

    }

    @Override
    public String toString() {
        return "TalkerBean{" +
                "name='" + name + '\'' +
                ", resourceId=" + resourceId +
                ", content=" + Arrays.toString(content) +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(resourceId);
        dest.writeStringArray(content);
    }

    public static final Creator<TalkerBean> CREATOR = new Creator<TalkerBean>() {
        @Override
        public TalkerBean createFromParcel(Parcel in) {
            return new TalkerBean(in);
        }

        @Override
        public TalkerBean[] newArray(int size) {
            return new TalkerBean[size];
        }
    };
}
