package com.qinshou.qinshoubox.im.manager;

import android.os.Handler;
import android.os.Looper;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IConversationDao;
import com.qinshou.qinshoubox.im.db.dao.IConversationMessageRelDao;
import com.qinshou.qinshoubox.im.db.dao.IMessageDao;

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
    private IConversationMessageRelDao mIConversationMessageRelDao;
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
        mConversationDao = databaseHelper.getDao(IConversationDao.class);
        mIConversationMessageRelDao = databaseHelper.getDao(IConversationMessageRelDao.class);
        mUserId = userId;
    }

    public MessageBean insert(boolean send, MessageBean messageBean) {
        // 插入消息
        messageBean = mMessageDao.insert(messageBean);
        // 插入或更新会话
        ConversationBean conversationBean = new ConversationBean();
        if (send) {
            conversationBean.setToUserId(messageBean.getToUserId());
            conversationBean.setLastMsgTimestamp(messageBean.getSendTimestamp());
        } else {
            conversationBean.setToUserId(messageBean.getFromUserId());
            conversationBean.setLastMsgTimestamp(messageBean.getReceiveTimestamp());
        }
        conversationBean.setLastMsgContent(messageBean.getContent());
        conversationBean.setLastMsgContentType(messageBean.getContentType());
        conversationBean.setType(messageBean.getType());
        mConversationDao.insert(send,conversationBean);
        // 插入会话与消息关系
        mIConversationMessageRelDao.insert(new ConversationMessageRelBean(conversationBean.getId(), messageBean.getPid()));
        return messageBean;
    }

    public List<MessageBean> getList(int type, String toUserId, int page, int pageSize) {
        ConversationBean conversationBean = mConversationDao.selectIdAndUnreadCountByTypeAndToUserId(type, toUserId);
        ShowLogUtil.logi("conversationBean--->" + conversationBean);
        if (conversationBean == null) {
            return new ArrayList<>();
        }
        ShowLogUtil.logi("到了吗");
        return mMessageDao.selectList(conversationBean.getId(), page, pageSize);
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
