package com.qinshou.immodule.manager;

import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.db.dao.IMessageDao;
import com.qinshou.immodule.db.dao.impl.MessageDaoImpl;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 20:15
 * Description:消息管理者
 */
public enum MessageManager {SINGLETON;
    /**
     * 消息 Dao
     */
    private IMessageDao mMessageDao;

    MessageManager() {
        mMessageDao = new MessageDaoImpl();
    }

    public int insertOrUpdate(boolean send, MessageBean messageBean) {
        return mMessageDao.insertOrUpdate(send,messageBean);
    }
}
