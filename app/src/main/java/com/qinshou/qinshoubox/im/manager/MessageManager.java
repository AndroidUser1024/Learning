package com.qinshou.qinshoubox.im.manager;

import com.qinshou.dbmodule.DatabaseManager;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.db.IMessageDao;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 20:15
 * Description:消息管理者
 */
public class MessageManager {
    private IMessageDao mMessageDao;

    public MessageManager() {
        mMessageDao = DatabaseManager.getInstance().getDao(IMessageDao.class);
    }

    public void save(MessageBean messageBean) {
        // 插入消息
        if (mMessageDao.existsById(messageBean.getPid()) == 0) {
            mMessageDao.insert(messageBean);
        } else {
            mMessageDao.updateById(messageBean);
        }
    }

    public List<MessageBean> getList(int type, String toUserId, int page, int pageSize) {
        return mMessageDao.selectList(type, toUserId, (page - 1) * pageSize, page * pageSize);
    }

    public MessageBean selectByPid(int pid) {
        return mMessageDao.selectById(pid);
    }
}
