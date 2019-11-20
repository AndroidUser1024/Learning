package com.qinshou.immodule.bean;


import com.qinshou.immodule.chat.ChatManager;

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
    private long id;
    /**
     * 发送者的 id
     */
    private int fromUserId;
    /**
     * 接收者的 id
     */
    private int toUserId;
    /**
     * 消息类型
     */
    private int type;
    /**
     * 消息内容类型
     */
    private int contentType;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 发送时间戳
     */
    private long sendTimestamp;
    /**
     * 发送时间戳
     */
    private long receiveTimestamp;
    /**
     * 消息状态
     */
    private int status;
    /**
     * 扩展字段
     */
    private String extend;

    private MessageBean() {
    }

    private MessageBean(long id, int fromUserId, int toUserId, Integer type, Integer contentType, String content, Long sendTimestamp, Long receiveTimestamp, Integer status, String extend) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSendTimestamp() {
        return sendTimestamp;
    }

    public void setSendTimestamp(long sendTimestamp) {
        this.sendTimestamp = sendTimestamp;
    }

    public long getReceiveTimestamp() {
        return receiveTimestamp;
    }

    public void setReceiveTimestamp(long receiveTimestamp) {
        this.receiveTimestamp = receiveTimestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/25 14:24
     * Description:创建一个握手消息
     *
     * @return 类型为握手消息的消息对象
     */
    public static MessageBean createHandshakeMessage() {
        MessageBean messageBean = new MessageBean();
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.fromUserId = ChatManager.SINGLETON.getUserId();
        messageBean.type = MessageType.HANDSHAKE.getValue();
        return messageBean;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/25 14:24
     * Description:创建一个语音消息
     *
     * @param toUserId 接收方用户 id
     * @param content  消息内容
     * @return 类型为普通文本的消息对象
     */
    public static MessageBean createTextMessage(int toUserId, String content) {
        MessageBean messageBean = new MessageBean();
        messageBean.toUserId = toUserId;
        messageBean.content = content;
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.fromUserId = ChatManager.SINGLETON.getUserId();
        messageBean.contentType = MessageContentType.TEXT.getValue();
        messageBean.type = MessageType.CHAT.getValue();
        return messageBean;
    }
}
