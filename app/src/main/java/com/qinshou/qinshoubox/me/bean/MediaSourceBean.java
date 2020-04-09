package com.qinshou.qinshoubox.me.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/9 16:35
 * Description:媒体资源实体类
 */
public class MediaSourceBean implements Parcelable {
    private String title;

    public MediaSourceBean() {
    }

    @Override
    public String toString() {
        return "MediaSourceBean{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected MediaSourceBean(Parcel in) {
        title = in.readString();
    }

    public static final Creator<MediaSourceBean> CREATOR = new Creator<MediaSourceBean>() {
        @Override
        public MediaSourceBean createFromParcel(Parcel in) {
            return new MediaSourceBean(in);
        }

        @Override
        public MediaSourceBean[] newArray(int size) {
            return new MediaSourceBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
    }
}
