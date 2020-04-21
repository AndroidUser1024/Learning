package com.qinshou.dbmodule.bean;

import com.qinshou.dbmodule.annotation.Column;
import com.qinshou.dbmodule.annotation.Id;
import com.qinshou.dbmodule.annotation.Table;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/21 15:59
 * Description:类描述
 */
@Table(name = "book")
public class BookBean {
    @Id(autoIncrement = true, useGeneratedKeys = true)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private float price;

    public BookBean() {
    }

    public BookBean(String name, String author, float price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
