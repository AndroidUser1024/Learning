package com.qinshou.immodule.bean;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 19:50
 * Description:会话和消息关联类
 */
public class ConversationMessageRelBean {
    private int id;
    private int conversationId;
    private int messageId;

    public ConversationMessageRelBean() {
    }

    public ConversationMessageRelBean(int conversationId, int messageId) {
        this.conversationId = conversationId;
        this.messageId = messageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}
