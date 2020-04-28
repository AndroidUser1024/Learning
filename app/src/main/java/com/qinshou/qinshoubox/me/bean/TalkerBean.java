package com.qinshou.qinshoubox.me.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/9 16:51
 * Description:对话者实体类
 */
public class TalkerBean implements Parcelable {
    private String name;
    private int resId;
    private ArrayList<String> contentList;

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

    public TalkerBean() {
    }

    public TalkerBean(String name, int resId, ArrayList<String> contentList) {
        this.name = name;
        this.resId = resId;
        this.contentList = contentList;
    }

    protected TalkerBean(Parcel in) {
        name = in.readString();
        resId = in.readInt();
        contentList = in.createStringArrayList();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(resId);
        dest.writeStringList(contentList);
    }

    @Override
    public String toString() {
        return "TalkerBean{" +
                "name='" + name + '\'' +
                ", resId=" + resId +
                ", contentList=" + contentList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public ArrayList<String> getContentList() {
        return contentList;
    }

    public void setContentList(ArrayList<String> contentList) {
        this.contentList = contentList;
    }
}
