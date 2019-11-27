package com.qinshou.qinshoubox.im.manager;

import android.util.Log;

import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.db.dao.IMessageDao;
import com.qinshou.qinshoubox.im.db.dao.impl.MessageDaoImpl;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 20:15
 * Description:消息管理者
 */
public class MessageManager {
    /**
     * 消息 Dao
     */
    private IMessageDao mMessageDao;

    MessageManager() {
        mMessageDao = new MessageDaoImpl();
    }

    public int insertOrUpdate(boolean send, MessageBean messageBean) {
        return mMessageDao.insertOrUpdate(send, messageBean);
    }

    public List<MessageBean> getList(int conversationId, int page, int pageSize) {
        return mMessageDao.getList(conversationId, page, pageSize);
    }

    public int setStatus(int status,int fromUserId, int toUserId, long sendTimestamp) {
        return mMessageDao.setStatus(status,fromUserId, toUserId, sendTimestamp);
    }
}
