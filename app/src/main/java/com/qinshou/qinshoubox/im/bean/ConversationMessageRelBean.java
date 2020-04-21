package com.qinshou.qinshoubox.im.bean;


import com.qinshou.dbmodule.annotation.Column;
import com.qinshou.dbmodule.annotation.Id;
import com.qinshou.dbmodule.annotation.Table;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/04 23:05
 * Description:会话和消息关联类
 */
@Table(name = "conversation_message_rel")
public class ConversationMessageRelBean {
    /**
     * 自增长 id
     */
    @Id(autoIncrement = true,useGeneratedKeys = true)
    @Column
    private int id;
    /**
     * 会话 id
     */
    @Column
    private int conversationId;
    /**
     * 消息自增长 id
     */
    @Column
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
