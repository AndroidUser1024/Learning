package com.qinshou.qinshoubox.knowledgesystem.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Description:知识体系目录实体类
 * Created by 禽兽先生
 * Created on 2018/4/10
 */

public class KnowledgeSystemBean {
    @SerializedName("children")
    public List<KnowledgeSystemBean> children;
    @SerializedName("courseId")
    public int courseId;
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("order")
    public int order;
    @SerializedName("parentChapterId")
    public int parentChapterId;
    @SerializedName("visible")
    public int visible;

    public KnowledgeSystemBean() {
    }

    public List<KnowledgeSystemBean> getChildren() {
        return children;
    }

    public void setChildren(List<KnowledgeSystemBean> children) {
        this.children = children;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "KnowledgeSystemBean{" +
                "children=" + children +
                ", courseId=" + courseId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", parentChapterId=" + parentChapterId +
                ", visible=" + visible +
                '}';
    }
}
