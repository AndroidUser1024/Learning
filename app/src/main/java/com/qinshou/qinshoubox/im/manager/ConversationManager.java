package com.qinshou.qinshoubox.im.manager;


import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.db.dao.IConversationDao;
import com.qinshou.qinshoubox.im.db.dao.IMessageDao;
import com.qinshou.qinshoubox.im.db.dao.impl.ConversationDaoImpl;
import com.qinshou.qinshoubox.im.db.dao.impl.MessageDaoImpl;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/23 8:58
 * Description:会话管理者
 */
public class ConversationManager {
    /**
     * 会话 Dao
     */
    private IConversationDao mConversationDao;
    /**
     * 消息 Dao
     */
    private IMessageDao mMessageDao;

    public ConversationManager() {
    }
}
