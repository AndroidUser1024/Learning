package com.qinshou.qinshoubox.homepage.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/16 16:56
 * Description:壁纸实体类
 */
public class WallpaperBean {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("path")
    private String path;

    public WallpaperBean() {
    }

    @Override
    public String toString() {
        return "WallpaperBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
