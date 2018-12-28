package com.qinshou.qinshoubox.homepage.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Description:首页文章实体类
 * Created by 禽兽先生
 * Created on 2018/4/6
 */

public class ArticleListBean {
    @SerializedName("curPage")
    private int currentPage;    //当前页码
    @SerializedName("offset")
    private int offset;
    @SerializedName("over")
    private boolean over;   //是否到最后
    @SerializedName("pageCount")
    private int pageCount;  //每一页有多少篇文章
    @SerializedName("size")
    private int size;   //一共有多少页
    @SerializedName("total")
    private int total;  //一共有多少篇文章
    @SerializedName("datas")
    private List<ArticleBean> articleList;

    public ArticleListBean() {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ArticleBean> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleBean> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return "ArticleListBean{" +
                "currentPage=" + currentPage +
                ", offset=" + offset +
                ", over=" + over +
                ", pageCount=" + pageCount +
                ", size=" + size +
                ", total=" + total +
                ", articleList=" + articleList +
                '}';
    }
}
