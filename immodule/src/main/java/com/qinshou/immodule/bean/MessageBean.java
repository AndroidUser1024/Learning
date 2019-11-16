package com.qinshou.immodule.bean;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/29 9:38
 * Description:消息实体类
 */
public class MessageBean {
    /**
     * 自增长 Id
     */
    private Long id;
    /**
     * 发送者的 id
     */
    private String fromUserId;
    /**
     * 接收者的 id
     */
    private String toUserId;
    /**
     * 消息类型
     */
    private Integer type;
    /**
     * 消息内容类型
     */
    private Integer contentType;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 发送时间戳
     */
    private Long sendTimestamp;
    /**
     * 发送时间戳
     */
    private Long receiveTimestamp;
    /**
     * 消息状态
     */
    private Integer status;
    /**
     * 扩展字段
     */
    private String extend;

    public MessageBean() {
    }

    public MessageBean(Long id, String fromUserId, String toUserId, Integer type, Integer contentType, String content, Long sendTimestamp, Long receiveTimestamp, Integer status, String extend) {
        this.id = id;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.type = type;
        this.contentType = contentType;
        this.content = content;
        this.sendTimestamp = sendTimestamp;
        this.receiveTimestamp = receiveTimestamp;
        this.status = status;
        this.extend = extend;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "id='" + id + '\'' +
                ", fromUserId='" + fromUserId + '\'' +
                ", toUserId='" + toUserId + '\'' +
                ", type=" + type +
                ", contentType=" + contentType +
                ", content='" + content + '\'' +
                ", sendTimestamp=" + sendTimestamp +
                ", receiveTimestamp=" + receiveTimestamp +
                ", status=" + status +
                ", extend='" + extend + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSendTimestamp() {
        return sendTimestamp;
    }

    public void setSendTimestamp(Long sendTimestamp) {
        this.sendTimestamp = sendTimestamp;
    }

    public Long getReceiveTimestamp() {
        return receiveTimestamp;
    }

    public void setReceiveTimestamp(Long receiveTimestamp) {
        this.receiveTimestamp = receiveTimestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }
}
