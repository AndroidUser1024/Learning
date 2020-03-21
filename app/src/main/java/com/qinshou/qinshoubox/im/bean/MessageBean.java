package com.qinshou.qinshoubox.im.bean;


import com.google.gson.Gson;
import com.jeejio.dbmodule.annotation.Column;
import com.jeejio.dbmodule.annotation.Id;
import com.jeejio.dbmodule.annotation.Table;
import com.qinshou.qinshoubox.conversation.bean.ImgBean;
import com.qinshou.qinshoubox.conversation.bean.VoiceBean;
import com.qinshou.qinshoubox.im.IMClient;
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
@Table
public class MessageBean {
    /**
     * 自增长 id
     */
    @Id(autoIncrement = true)
    @Column(type = Column.Type.INTEGER)
    private int pid;
    /**
     * Id
     */
    @Column
    private String id;
    /**
     * 发送者的 id
     */
    @Column
    private String fromUserId;
    /**
     * 接收者的 id
     */
    @Column
    private String toUserId;
    /**
     * 消息类型
     */
    @Column(type = Column.Type.INTEGER)
    private int type;
    /**
     * 消息内容类型
     */
    @Column(type = Column.Type.INTEGER)
    private int contentType;
    /**
     * 消息内容
     */
    @Column
    private String content;
    /**
     * 发送时间戳
     */
    @Column(type = Column.Type.INTEGER)
    private long sendTimestamp;
    /**
     * 发送时间戳
     */
    @Column(type = Column.Type.INTEGER)
    private long receiveTimestamp;
    /**
     * 消息状态
     */
    @Column(type = Column.Type.INTEGER)
    private int status;
    /**
     * 扩展字段
     */@Column
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
        messageBean.fromUserId = fromUserId;
        messageBean.sendTimestamp = System.currentTimeMillis();
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
        messageBean.fromUserId = IMClient.SINGLETON.getUserDetailBean().getId();
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
     * @param path     语音文件路径
     * @param time     语音时长
     * @return 类型为语音的消息对象
     */
    public static MessageBean createVoiceMessage(String toUserId, String path, long time) {
        MessageBean messageBean = new MessageBean();
        messageBean.fromUserId = IMClient.SINGLETON.getUserDetailBean().getId();
        messageBean.toUserId = toUserId;
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.contentType = MessageContentType.VOICE.getValue();
        messageBean.type = MessageType.CHAT.getValue();
        messageBean.extend = new Gson().toJson(new VoiceBean(path, time));
        return messageBean;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/12/30 17:03
     * Description:创建一个图片消息
     *
     * @param toUserId 接收方用户 id
     * @param path     图片路径
     * @return 类型为图片的消息对象
     */
    public static MessageBean createImgMessage(String toUserId, String path) {
        MessageBean messageBean = new MessageBean();
        messageBean.fromUserId = IMClient.SINGLETON.getUserDetailBean().getId();
        messageBean.toUserId = toUserId;
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.contentType = MessageContentType.IMAGE.getValue();
        messageBean.type = MessageType.CHAT.getValue();
        messageBean.extend = new Gson().toJson(new ImgBean(path));
        return messageBean;
    }

    public static MessageBean createClientReceiptMessage() {
        MessageBean messageBean = new MessageBean();
        messageBean.fromUserId = IMClient.SINGLETON.getUserDetailBean().getId();
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.type = MessageType.CLIENT_RECEIPT.getValue();
        return messageBean;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/1 10:37
     * Description:创建一个心跳消息
     *
     * @return 类型为心跳的消息
     */
    public static MessageBean createHeartBeatMessage() {
        MessageBean messageBean = new MessageBean();
        messageBean.fromUserId = IMClient.SINGLETON.getUserDetailBean().getId();
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.type = MessageType.HEART_BEAT.getValue();
        return messageBean;
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2019/12/25 22:09
     * Description:创建单聊的系统消息
     */
    public static MessageBean createChatSystemMessage(String fromUserId, String toUserId, FriendStatusBean friendStatusBean) {
        MessageBean messageBean = new MessageBean();
        messageBean.fromUserId = fromUserId;
        messageBean.toUserId = toUserId;
        messageBean.type = MessageType.CHAT.getValue();
        messageBean.contentType = MessageContentType.SYSTEM.getValue();
        messageBean.extend = new Gson().toJson(friendStatusBean);
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.status = MessageStatus.SENDED.getValue();
        return messageBean;
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/03/21 15:01
     * Description:创建群聊的系统消息
     */
    public static MessageBean createGroupChatStatusMessage(String fromUserId
            , String toUserId
            , GroupChatStatusBean groupChatStatusBean) {
        MessageBean messageBean = new MessageBean();
        messageBean.fromUserId = fromUserId;
        messageBean.toUserId = toUserId;
        messageBean.type = MessageType.GROUP_CHAT.getValue();
        messageBean.contentType = MessageContentType.SYSTEM.getValue();
        messageBean.extend = new Gson().toJson(groupChatStatusBean);
        messageBean.sendTimestamp = System.currentTimeMillis();
        messageBean.status = MessageStatus.SENDED.getValue();
        return messageBean;
    }
}
