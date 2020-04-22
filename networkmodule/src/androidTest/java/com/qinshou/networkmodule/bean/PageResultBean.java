package com.qinshou.networkmodule.bean;

import java.util.List;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2019/12/3 13:06
 * Description:分页查询返回结果映射类
 */
public class PageResultBean<T> {
    private int page;
    private int pageSize;
    private int totalPage;
    private List<T> list;

    public PageResultBean() {
    }

    public PageResultBean(int page, int pageSize, int totalPage, List<T> list) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageResultBean{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
