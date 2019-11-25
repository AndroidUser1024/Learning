package com.qinshou.qinshoubox.im.manager;


import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.db.dao.IConversationDao;
import com.qinshou.qinshoubox.im.db.dao.IMessageDao;
import com.qinshou.qinshoubox.im.db.dao.impl.ConversationDaoImpl;
import com.qinshou.qinshoubox.im.db.dao.impl.MessageDaoImpl;

import java.util.List;

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

    ConversationManager() {
        mConversationDao = new ConversationDaoImpl();
        mMessageDao = new MessageDaoImpl();
    }

    public ConversationBean getByTypeAndToUserId(int type, int toUserId) {
        return mConversationDao.getByTypeAndToUserId(type, toUserId);
    }

    public int insertOrUpdate(ConversationBean conversationBean) {
        return mConversationDao.insertOrUpdate(conversationBean);
    }

    public List<ConversationBean> getList() {
        return mConversationDao.getList();
    }

    public int resetUnreadCount(int id) {
        return mConversationDao.resetUnreadCount(id);
    }

    public int getTotalUnreadCount() {
        return mConversationDao.getTotalUnreadCount();
    }
}
