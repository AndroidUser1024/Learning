package com.qinshou.qinshoubox.im.bean;


import com.qinshou.dbmodule.annotation.Column;
import com.qinshou.dbmodule.annotation.Id;
import com.qinshou.dbmodule.annotation.Table;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/04 23:05
 * Description:好友关系实体类
 */
@Table(name = "friend")
public class FriendBean {
    /**
     * 好友的 id
     */
    @Id
    @Column
    private String id;
    /**
     * 好友状态
     */
    @Column(type = Column.Type.INTEGER)
    private int status;
    /**
     * 备注
     */
    @Column
    private String remark;
    /**
     * 是否置顶,0 是非置顶,1 是置顶
     */
    @Column(type = Column.Type.INTEGER)
    private int top;
    /**
     * 是否免打扰,0 是非免打扰,1 是免打扰
     */
    @Column(type = Column.Type.INTEGER)
    private int doNotDisturb;
    /**
     * 是否加入了黑名单,0 是没有加入,1 是加入了
     */
    @Column(type = Column.Type.INTEGER)
    private int blackList;

    public FriendBean() {
    }

    public FriendBean(String id, int status, String remark, int top, int doNotDisturb, int blackList) {
        this.id = id;
        this.status = status;
        this.remark = remark;
        this.top = top;
        this.doNotDisturb = doNotDisturb;
        this.blackList = blackList;
    }

    @Override
    public String toString() {
        return "FriendBean{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", top=" + top +
                ", doNotDisturb=" + doNotDisturb +
                ", blackList=" + blackList +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getDoNotDisturb() {
        return doNotDisturb;
    }

    public void setDoNotDisturb(int doNotDisturb) {
        this.doNotDisturb = doNotDisturb;
    }

    public int getBlackList() {
        return blackList;
    }

    public void setBlackList(int blackList) {
        this.blackList = blackList;
    }
}
