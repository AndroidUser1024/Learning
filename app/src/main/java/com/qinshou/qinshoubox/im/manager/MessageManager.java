package com.qinshou.qinshoubox.im.manager;

import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.db.dao.IMessageDao;
import com.qinshou.immodule.db.dao.impl.MessageDaoImpl;

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

    public MessageManager() {
        mMessageDao = new MessageDaoImpl();
    }

    public int insertOrUpdate(boolean send, MessageBean messageBean) {
        return mMessageDao.insertOrUpdate(send, messageBean);
    }

    public List<MessageBean> getList(int conversationId, int page, int pageSize) {
        return mMessageDao.getList(conversationId, page, pageSize);
    }

    public int setStatus(int status, int fromUserId, int toUserId, long sendTimestamp) {
        return mMessageDao.setStatus(status, fromUserId, toUserId, sendTimestamp);
    }

    public MessageBean getByFromUserIdAndToUserIdAndTypeAndSendTimestamp(int fromUserId, int toUserId, int type, long sendTimestamp) {
        return mMessageDao.getByFromUserIdAndToUserIdAndTypeAndSendTimestamp(fromUserId, toUserId, type, sendTimestamp);
    }
}
