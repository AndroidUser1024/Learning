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

    public MessageManager(DatabaseHelper databaseHelper, String userId) {
        mMessageDao = databaseHelper.getDao(IMessageDao.class);
        mConversationDao = databaseHelper.getDao(IConversationDao.class);
        mConversationMessageRelDao = databaseHelper.getDao(IConversationMessageRelDao.class);
        mUserId = userId;
    }

    public MessageBean insert(boolean send, MessageBean messageBean) {
        // 插入消息
        ShowLogUtil.logi("messageBean--->" + messageBean);
        if (messageBean.getPid() == 0) {
            messageBean = mMessageDao.insert(messageBean);
        } else {
            mMessageDao.update(messageBean);
        }
        // 插入或更新会话
        ConversationBean conversationBean = new ConversationBean();
        if (send || messageBean.getType() == MessageType.GROUP_CHAT.getValue()) {
            // 发送的消息, conversation 的目标 id 为接收方 id
            // 群聊的发送方永远是自己,接收方永远是群 id,所以群聊类型的消息,conversation 的目标 id 为永远为群 id
            conversationBean.setToUserId(messageBean.getToUserId());
            conversationBean.setLastMsgTimestamp(messageBean.getSendTimestamp());
        } else {
            // 接收的消息, conversation 的目标 id 为发送方 id
            conversationBean.setToUserId(messageBean.getFromUserId());
            conversationBean.setLastMsgTimestamp(messageBean.getReceiveTimestamp());
        }
        conversationBean.setLastMsgContent(messageBean.getContent());
        conversationBean.setLastMsgContentType(messageBean.getContentType());
        conversationBean.setType(messageBean.getType());
        mConversationDao.insert(send, conversationBean);
        // 插入会话与消息关系
        ConversationMessageRelBean conversationMessageRelBean = new ConversationMessageRelBean(conversationBean.getId(), messageBean.getPid());
        if (!mConversationMessageRelDao.existsByConversationIdAndMessagePid(conversationMessageRelBean)) {
            mConversationMessageRelDao.insert(conversationMessageRelBean);
        }
        return messageBean;
    }

    public List<MessageBean> getList(int type, String toUserId, int page, int pageSize) {
        ConversationBean conversationBean = mConversationDao.selectIdAndUnreadCountByTypeAndToUserId(type, toUserId);
        if (conversationBean == null) {
            return new ArrayList<>();
        }
        return mMessageDao.selectList(conversationBean.getId(), page, pageSize);
    }

    public MessageBean selectByPid(int pid) {
        return mMessageDao.selectByPid(pid);
    }

    public int update(MessageBean messageBean) {
        return mMessageDao.update(messageBean);
    }
//    public MessageBean getByFromUserIdAndToUserIdAndTypeAndSendTimestamp(int fromUserId, int toUserId, int type, long sendTimestamp) {
//        return mMessageDao.getByFromUserIdAndToUserIdAndTypeAndSendTimestamp(fromUserId, toUserId, type, sendTimestamp);
//    }
}
