package com.qinshou.immodule.bean;


import com.qinshou.immodule.manager.IMClient;
import com.qinshou.immodule.enums.MessageContentType;
import com.qinshou.immodule.enums.MessageType;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/29 9:38
 * Description:消息实体类
 */
public class MessageBean {
    /**
     * Id
     */
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/25 14:24
     * Description:创建一个握手消息
     *
     * @return 类型为握手消息的消息对象
     */
    public static MessageBean createHandshakeMessage(String fromUserId) {
        MessageBean messageBean = new MessageBean();
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.fromUserId = fromUserId;
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
    public static MessageBean createTextMessage(String toUserId, String content) {
        MessageBean messageBean = new MessageBean();
        messageBean.toUserId = toUserId;
        messageBean.content = content;
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.fromUserId = IMClient.SINGLETON.getUserId();
        messageBean.contentType = MessageContentType.TEXT.getValue();
        messageBean.type = MessageType.CHAT.getValue();
        return messageBean;
    }

    public static MessageBean createClientReceiptMessage(String fromUserId) {
        MessageBean messageBean = new MessageBean();
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.fromUserId = fromUserId;
        messageBean.type = MessageType.CLIENT_RECEIPT.getValue();
        return messageBean;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/1 10:37
     * Description:创建一个心跳消息
     *
     * @param fromUserId 发送者的 id
     * @return 类型为心跳的消息
     */
    public static MessageBean createHeartBeatMessage(String fromUserId) {
        MessageBean messageBean = new MessageBean();
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.fromUserId = fromUserId;
        messageBean.type = MessageType.HEART_BEAT.getValue();
        return messageBean;
    }
}
