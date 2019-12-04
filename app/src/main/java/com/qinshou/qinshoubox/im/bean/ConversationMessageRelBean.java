package com.qinshou.qinshoubox.im.bean;


/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/04 23:05
 * Description:会话和消息关联类
 */
public class ConversationMessageRelBean {
    private int id;
    private int conversationId;
    private int messagePid;

    public ConversationMessageRelBean() {
    }

    public ConversationMessageRelBean(int conversationId, int messagePid) {
        this.conversationId = conversationId;
        this.messagePid = messagePid;
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

    public int getMessagePid() {
        return messagePid;
    }

    public void setMessagePid(int messagePid) {
        this.messagePid = messagePid;
    }
}
