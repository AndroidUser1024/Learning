package com.qinshou.qinshoubox.knowledgesystem.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Description:热门搜索词实体类
 * Created by 禽兽先生
 * Created on 2018/4/13
 */
public class HotSearchWordsBean {
    @SerializedName("id")
    private int id;
    @SerializedName("link")
    private String link;
    @SerializedName("name")
    private String name;
    @SerializedName("order")
    private int order;
    @SerializedName("visible")
    private int visible;

    public HotSearchWordsBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "HotSearchWordsBean{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", visible=" + visible +
                '}';
    }
}
