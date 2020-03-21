package com.qinshou.qinshoubox.im.manager;

import android.os.Handler;
import android.os.Looper;

import com.jeejio.dbmodule.DatabaseManager;
import com.jeejio.dbmodule.dao.IBaseDao;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 20:15
 * Description:消息管理者
 */
public class MessageManager {
    private IBaseDao<MessageBean> mMessageDao;
    private IBaseDao<ConversationBean> mConversationDao;
    private IBaseDao<ConversationMessageRelBean> mConversationMessageRelDao;

    public MessageManager() {
        mConversationDao = DatabaseManager.getInstance().getDaoByClass(ConversationBean.class);
        mMessageDao = DatabaseManager.getInstance().getDaoByClass(MessageBean.class);
        mConversationMessageRelDao = DatabaseManager.getInstance().getDaoByClass(ConversationMessageRelBean.class);
    }

    public void insertOrUpdate(MessageBean messageBean) {
//        // 插入消息
        mMessageDao.save(messageBean);
//        if (mMessageDao.existsByPid(messageBean.getPid())) {
//            mMessageDao.update(messageBean);
//        } else {
//            mMessageDao.insert(messageBean);
//        }
    }

    public List<MessageBean> getList(int type, String toUserId, int page, int pageSize) {
//        ConversationBean conversationBean = mConversationDao.selectByTypeAndToUserId(type, toUserId);
//        if (conversationBean == null) {
//            return new ArrayList<>();
//        }
//        return mMessageDao.selectList(conversationBean.getId(), page, pageSize);
        return null;
    }

    public MessageBean selectByPid(int pid) {
//        return mMessageDao.selectByPid(pid);
        return null;
    }
}
