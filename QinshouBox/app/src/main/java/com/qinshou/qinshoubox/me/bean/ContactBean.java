package com.qinshou.qinshoubox.me.bean;

/**
 * Description:联系人实体类
 * Created by 禽兽先生
 * Created on 2017/4/3
 */

public class ContactBean {
    private String name;
    private String phoneNumber;
    private String sortLetter;//显示数据拼音的首字母

    public ContactBean() {
    }

    public ContactBean(String name, String phoneNumber, String sortLetter) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sortLetter = sortLetter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSortLetter() {
        return sortLetter;
    }

    public void setSortLetter(String sortLetter) {
        this.sortLetter = sortLetter;
    }


    @Override
    public String toString() {
        return "ContactBean{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sortLetter='" + sortLetter + '\'' +
                '}';
    }
}
