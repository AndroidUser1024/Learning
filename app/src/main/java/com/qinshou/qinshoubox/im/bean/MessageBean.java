package com.qinshou.qinshoubox.im.bean;


import com.google.gson.Gson;
import com.qinshou.qinshoubox.conversation.bean.ImgBean;
import com.qinshou.qinshoubox.conversation.bean.VoiceBean;
import com.qinshou.qinshoubox.im.enums.MessageContentType;
import com.qinshou.qinshoubox.im.enums.MessageStatus;
import com.qinshou.qinshoubox.im.enums.MessageType;

import java.util.Map;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/04 23:05
 * Description:消息实体类
 */
public class MessageBean {
    /**
     * 自增长 id
     */
    private int pid;
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

    public MessageBean() {
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "pid=" + pid +
                ", id='" + id + '\'' +
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
        messageBean.contentType = MessageContentType.TEXT.getValue();
        messageBean.type = MessageType.CHAT.getValue();
        return messageBean;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/12/30 17:03
     * Description:创建一个语音消息
     *
     * @param toUserId 接收方用户 id
     * @param url      语音上传后的 url
     * @param time     语音时长
     * @return 类型为语音的消息对象
     */
    public static MessageBean createVoiceMessage(String toUserId, String url, long time) {
        MessageBean messageBean = new MessageBean();
        messageBean.toUserId = toUserId;
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.contentType = MessageContentType.VOICE.getValue();
        messageBean.type = MessageType.CHAT.getValue();
        messageBean.extend = new Gson().toJson(new VoiceBean(url, time));
        return messageBean;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/12/30 17:03
     * Description:创建一个图片消息
     *
     * @param toUserId 接收方用户 id
     * @param url      图片上传后的 url
     * @param smallUrl 图片缩略图 url
     * @return 类型为图片的消息对象
     */
    public static MessageBean createImgMessage(String toUserId, String url, String smallUrl) {
        MessageBean messageBean = new MessageBean();
        messageBean.toUserId = toUserId;
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.contentType = MessageContentType.IMAGE.getValue();
        messageBean.type = MessageType.CHAT.getValue();
        messageBean.extend = new Gson().toJson(new ImgBean(url, smallUrl));
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

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2019/12/25 22:09
     * Description:创建单聊的系统消息
     */
    public static MessageBean createChatSystemMessage(String fromUserId, String toUserId, Map<String, Object> map) {
        MessageBean messageBean = new MessageBean();
        messageBean.setFromUserId(fromUserId);
        messageBean.setToUserId(toUserId);
        messageBean.setType(MessageType.CHAT.getValue());
        messageBean.setContentType(MessageContentType.SYSTEM.getValue());
        messageBean.setExtend(new Gson().toJson(map));
        messageBean.setSendTimestamp(System.currentTimeMillis());
        messageBean.setStatus(MessageStatus.SENDED.getValue());
        return messageBean;
    }
}
