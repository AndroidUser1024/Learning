package com.qinshou.qinshoubox.music.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Description:音乐实体类
 * Author: QinHao
 * Date: 2019/3/25 8:46
 */
public class MusicBean implements Parcelable {
    private String album;   //专辑名
    private String artist;  //歌手
    private int duration;   //时长
    private String name;    //歌曲名
    private String path;    //路径
    private long size;  //大小


    public MusicBean() {
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "MusicBean{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", album='" + album + '\'' +
                ", artist='" + artist + '\'' +
                ", size=" + size +
                ", duration=" + duration +
                '}';
    }

    protected MusicBean(Parcel in) {
        album = in.readString();
        artist = in.readString();
        duration = in.readInt();
        name = in.readString();
        path = in.readString();
        size = in.readLong();
    }

    public static final Creator<MusicBean> CREATOR = new Creator<MusicBean>() {
        @Override
        public MusicBean createFromParcel(Parcel in) {
            return new MusicBean(in);
        }

        @Override
        public MusicBean[] newArray(int size) {
            return new MusicBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(album);
        dest.writeString(artist);
        dest.writeInt(duration);
        dest.writeString(name);
        dest.writeString(path);
        dest.writeLong(size);
    }
}
