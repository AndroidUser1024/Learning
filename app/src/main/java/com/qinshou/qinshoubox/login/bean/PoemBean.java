package com.qinshou.qinshoubox.login.bean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/10 11:08
 * Description:诗词实体类
 */
public class PoemBean {
    /**
     * 自增长 id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 朝代
     */
    private String dynasty;
    /**
     * 作者
     */
    private String author;
    /**
     * 内容
     */
    private String content;
    /**
     * 分类 id
     */
    private Integer typeId;

    public PoemBean() {
    }

    @Override
    public String toString() {
        return "PoemBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", typeId='" + typeId + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
