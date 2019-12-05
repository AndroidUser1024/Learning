package com.qinshou.qinshoubox.im.manager;

import android.os.Handler;
import android.os.Looper;

import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IMessageDao;

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
    private String mUserId;
    /**
     * 线程池,线程数量不定,适合执行大量耗时较少的任务
     */
    private ExecutorService mExecutorService = Executors.newCachedThreadPool();
    /**
     * 将回调切换到主线程的 Handler
     */
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public MessageManager(DatabaseHelper databaseHelper, String userId) {
        mMessageDao = databaseHelper.getDao(IMessageDao.class);
        mUserId = userId;
    }

    public int insert(boolean send, MessageBean messageBean) {
        return mMessageDao.insert(send, messageBean);
    }
//
//    public List<MessageBean> getList(int conversationId, int page, int pageSize) {
//        return mMessageDao.getList(conversationId, page, pageSize);
//    }
//
//    public int setStatus(int status, int fromUserId, int toUserId, long sendTimestamp) {
//        return mMessageDao.setStatus(status, fromUserId, toUserId, sendTimestamp);
//    }
//
//    public MessageBean getByFromUserIdAndToUserIdAndTypeAndSendTimestamp(int fromUserId, int toUserId, int type, long sendTimestamp) {
//        return mMessageDao.getByFromUserIdAndToUserIdAndTypeAndSendTimestamp(fromUserId, toUserId, type, sendTimestamp);
//    }
}
