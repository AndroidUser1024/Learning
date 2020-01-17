package com.qinshou.qinshoubox.im.manager;

import android.os.Handler;
import android.os.Looper;

import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IConversationDao;
import com.qinshou.qinshoubox.im.db.dao.IConversationMessageRelDao;
import com.qinshou.qinshoubox.im.db.dao.IMessageDao;
import com.qinshou.qinshoubox.im.enums.MessageType;

import java.util.ArrayList;
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
    /**
     * 消息 Dao
     */
    private IMessageDao mMessageDao;
    /**
     * 会话 Dao
     */
    private IConversationDao mConversationDao;
    /**
     * 会话与消息关系 Dao
     */
    private IConversationMessageRelDao mConversationMessageRelDao;
    private String mUserId;
    /**
     * 线程池,线程数量不定,适合执行大量耗时较少的任务
     */
    private ExecutorService mExecutorService = Executors.newCachedThreadPool();
    /**
     * 将回调切换到主线程的 Handler
     */
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public MessageManager(String userId, DatabaseHelper databaseHelper) {
        mMessageDao = databaseHelper.getDao(IMessageDao.class);
        mConversationDao = databaseHelper.getDao(IConversationDao.class);
        mConversationMessageRelDao = databaseHelper.getDao(IConversationMessageRelDao.class);
        mUserId = userId;
    }

    public void insertOrUpdate(MessageBean messageBean) {
        // 插入消息
        if (mMessageDao.existsByPid(messageBean.getPid())) {
            mMessageDao.update(messageBean);
        } else {
            mMessageDao.insert(messageBean);
        }
    }

    public List<MessageBean> getList(int type, String toUserId, int page, int pageSize) {
        ConversationBean conversationBean = mConversationDao.selectByTypeAndToUserId(type, toUserId);
        if (conversationBean == null) {
            return new ArrayList<>();
        }
        return mMessageDao.selectList(conversationBean.getId(), page, pageSize);
    }

    public MessageBean selectByPid(int pid) {
        return mMessageDao.selectByPid(pid);
    }
}
