package com.qinshou.qinshoubox.im.bean;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2019/12/26 19:24
 * Description:服务端回执的实体类
 */
public class ServerReceiptBean {
    private int pid;
    private String id;
    private int status;
    private int failureCode;

    public ServerReceiptBean() {
    }

    public ServerReceiptBean(int pid, String id, int status, int failureCode) {
        this.pid = pid;
        this.id = id;
        this.status = status;
        this.failureCode = failureCode;
    }

    @Override
    public String toString() {
        return "ServerReceiptBean{" +
                "pid=" + pid +
                ", id='" + id + '\'' +
                ", status=" + status +
                ", failureCode=" + failureCode +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public int getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(int failureCode) {
        this.failureCode = failureCode;
    }
}
