package com.qinshou.qinshoubox.me.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/4/28
 */

public class TalkerEntity implements Parcelable {
    private String mName;
    private int mResourceId;
    private String[] mContent;

    public TalkerEntity() {
    }

    protected TalkerEntity(Parcel in) {
        mName = in.readString();
        mResourceId = in.readInt();
        mContent = in.createStringArray();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getResourceId() {
        return mResourceId;
    }

    public void setResourceId(int resourceId) {
        mResourceId = resourceId;
    }

    public String[] getContent() {
        return mContent;
    }

    public void setContent(String[] content) {
        this.mContent = content;

    }

    @Override
    public String toString() {
        return "TalkerEntity{" +
                "mName='" + mName + '\'' +
                ", mResourceId=" + mResourceId +
                ", content=" + Arrays.toString(mContent) +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeInt(mResourceId);
        dest.writeStringArray(mContent);
    }

    public static final Creator<TalkerEntity> CREATOR = new Creator<TalkerEntity>() {
        @Override
        public TalkerEntity createFromParcel(Parcel in) {
            return new TalkerEntity(in);
        }

        @Override
        public TalkerEntity[] newArray(int size) {
            return new TalkerEntity[size];
        }
    };
}
