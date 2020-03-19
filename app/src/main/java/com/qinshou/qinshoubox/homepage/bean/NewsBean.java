package com.qinshou.qinshoubox.homepage.bean;

import com.qinshou.commonmodule.db.annotation.Column;
import com.qinshou.commonmodule.db.annotation.Id;
import com.qinshou.commonmodule.db.annotation.Table;

@Table(name = "news")
public class NewsBean {
    @Id(autoIncrement = true)
    @Column
    private Integer id;
    @Column
    private String href;
    @Column(name = "img_small")
    private String imgSmall;
    private String imgBig;
    private String titleChinese;
    private String titleEnglish;
    private Long publishTime;
    private String introduction;
    private String sourceChinese;
    private String sourceEnglish;
    private String translatorAndEditor;
    private String contentHtml;

    @Override
    public String toString() {
        return "NewsBean{" +
                "id=" + id +
                ", href='" + href + '\'' +
                ", imgSmall='" + imgSmall + '\'' +
                ", imgBig='" + imgBig + '\'' +
                ", titleChinese='" + titleChinese + '\'' +
                ", titleEnglish='" + titleEnglish + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", introduction='" + introduction + '\'' +
                ", sourceChinese='" + sourceChinese + '\'' +
                ", sourceEnglish='" + sourceEnglish + '\'' +
                ", translatorAndEditor='" + translatorAndEditor + '\'' +
                ", contentHtml='" + contentHtml + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgSmall() {
        return imgSmall;
    }

    public void setImgSmall(String imgSmall) {
        this.imgSmall = imgSmall;
    }

    public String getImgBig() {
        return imgBig;
    }

    public void setImgBig(String imgBig) {
        this.imgBig = imgBig;
    }

    public String getTitleChinese() {
        return titleChinese;
    }

    public void setTitleChinese(String titleChinese) {
        this.titleChinese = titleChinese;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSourceChinese() {
        return sourceChinese;
    }

    public void setSourceChinese(String sourceChinese) {
        this.sourceChinese = sourceChinese;
    }

    public String getSourceEnglish() {
        return sourceEnglish;
    }

    public void setSourceEnglish(String sourceEnglish) {
        this.sourceEnglish = sourceEnglish;
    }

    public String getTranslatorAndEditor() {
        return translatorAndEditor;
    }

    public void setTranslatorAndEditor(String translatorAndEditor) {
        this.translatorAndEditor = translatorAndEditor;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }
}
