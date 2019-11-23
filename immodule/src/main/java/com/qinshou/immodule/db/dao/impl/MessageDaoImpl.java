package com.qinshou.immodule.db.dao.impl;


import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.TransactionManager;
import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.bean.ConversationMessageRelBean;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.db.DBHelper;
import com.qinshou.immodule.db.dao.IConversationDao;
import com.qinshou.immodule.db.dao.IConversationMessageRelDao;
import com.qinshou.immodule.db.dao.IMessageDao;

import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/5 17:34
 * Description:MessageDao 的实现类
 */
public class MessageDaoImpl implements IMessageDao {
    private Dao<MessageBean, Integer> mDao;
    /**
     * 会话 Dao
     */
    private IConversationDao mConversationDao;
    /**
     * 会话与消息关系表 Dao
     */
    private IConversationMessageRelDao mConversationMessageRelDao;

    public MessageDaoImpl() {
        try {
            mDao = DBHelper.getInstance().getDao(MessageBean.class);
            mConversationDao = new ConversationDaoImpl();
            mConversationMessageRelDao = new ConversationMessageRelDaoImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrUpdate(final boolean send, final MessageBean messageBean) {
        try {
            TransactionManager transactionManager = new TransactionManager(mDao.getConnectionSource());
            return transactionManager.callInTransaction(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
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
                        conversationBean = new ConversationBean();
                    }
                    conversationBean.setToUserId(toUserId);
                    conversationBean.setType(messageBean.getType());
                    conversationBean.setLastMsgContent(messageBean.getContent());
                    conversationBean.setLastMsgContentType(messageBean.getContentType());
                    conversationBean.setLastMsgTime(lastMsgTime);
                    conversationBean.setUnreadCount(conversationBean.getUnreadCount() + 1);
                    mConversationDao.insertOrUpdate(conversationBean);

                    mDao.createOrUpdate(messageBean);
                    mConversationMessageRelDao.insertOrUpdate(new ConversationMessageRelBean(conversationBean.getId(), messageBean.getPid()));
                    return 1;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}