package com.qinshou.immodule.manager;

import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.db.dao.IConversationDao;
import com.qinshou.immodule.db.dao.IMessageDao;
import com.qinshou.immodule.db.dao.impl.ConversationDaoImpl;
import com.qinshou.immodule.db.dao.impl.MessageDaoImpl;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 20:15
 * Description:消息管理者
 */
public enum MessageManager {SINGLETON;
    /**
     * 会话 Dao
     */
    private IConversationDao mConversationDao;
    /**
     * 消息 Dao
     */
    private IMessageDao mMessageDao;

    MessageManager() {
        mConversationDao = new ConversationDaoImpl();
        mMessageDao = new MessageDaoImpl();
    }

    public int insertOrUpdate(boolean send, MessageBean messageBean) {
        int toUserId;
        long lastMsgTime;
        if (send) {
            toUserId = messageBean.getToUserId();
            lastMsgTime = messageBean.getSendTimestamp();
        } else {
            toUserId = messageBean.getFromUserId();
            lastMsgTime = messageBean.getReceiveTimestamp();
        }
        ConversationBean conversationBean = mConversationDao.getByToUserId(toUserId);
        if (conversationBean == null) {
            conversationBean = new ConversationBean(toUserId, messageBean.getType(), messageBean.getContent(), messageBean.getContentType(), lastMsgTime, 0);
        }
        mConversationDao.insertOrUpdate(conversationBean);

        return mMessageDao.insertOrUpdate(messageBean);
    }
}
