package com.qinshou.networkmodule.bean;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/16 16:56
 * Description:壁纸实体类
 */
public class WallpaperBean {
    private int id;
    private String name;
    private String url;

    public WallpaperBean() {
    }

    @Override
    public String toString() {
        return "WallpaperBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
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

    public String getUrl() {
        return url;
    }

    public void setPath(String path) {
        this.url = path;
    }
}
