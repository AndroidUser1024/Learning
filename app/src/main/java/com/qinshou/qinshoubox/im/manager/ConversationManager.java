package com.qinshou.qinshoubox.im.manager;


import com.jeejio.dbmodule.DatabaseManager;
import com.jeejio.dbmodule.dao.IBaseDao;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/23 8:58
 * Description:会话管理者
 */
public class ConversationManager {
    private IBaseDao<ConversationBean> mConversationDao;
    private IBaseDao<MessageBean> mMessageDao;
    private IBaseDao<ConversationMessageRelBean> mConversationMessageRelDao;

    public ConversationManager() {
        mConversationDao = DatabaseManager.getInstance().getDaoByClass(ConversationBean.class);
        mMessageDao = DatabaseManager.getInstance().getDaoByClass(MessageBean.class);
        mConversationMessageRelDao = DatabaseManager.getInstance().getDaoByClass(ConversationMessageRelBean.class);
    }

    public void insertOrUpdate(ConversationBean conversationBean) {
//        if (mConversationDao.existsById(conversationBean.getId())) {
//            mConversationDao.update(conversationBean);
//        } else {
//            mConversationDao.insert(conversationBean);
//        }
    }

    public void insertConversationMessageRel(ConversationMessageRelBean conversationMessageRelBean) {
//        if (!mConversationMessageRelDao.existsByConversationIdAndMessagePid(conversationMessageRelBean)) {
//            mConversationMessageRelDao.insert(conversationMessageRelBean);
//        }
    }

    public void deleteById(int id) {
//        mConversationDao.deleteById(id);
    }

    public List<ConversationBean> getList() {
//        return mConversationDao.selectList();
        return null;
    }

    public List<ConversationBean> getListOrderByLastMsgTimeDesc() {
//        return mConversationDao.selectListOrderByLastMsgTimeDesc();
        return null;
    }

    public List<ConversationBean> getListOrderByTopDescAndLastMsgTimeDesc() {
//        return mConversationDao.selectListOrderByTopDescAndLastMsgTimeDesc();
        return null;
    }

    public ConversationBean getByTypeAndToUserId(int type, String toUserId) {
//        return mConversationDao.selectByTypeAndToUserId(type, toUserId);
        return null;
    }

    public int getTotalUnreadCount() {
//        return mConversationDao.getTotalUnreadCount();
        return 0;
    }

    public void setUnreadCount(int unreadCount, int id) {
//        ConversationBean conversationBean = mConversationDao.selectById(id);
//        if (conversationBean == null) {
//            return;
//        }
//        conversationBean.setUnreadCount(unreadCount);
//        mConversationDao.update(conversationBean);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/1/16 13:24
     * Description:清空会话,只是删除该会话的所有消息,但是会话并不会被删除
     *
     * @param type     单聊还是群聊
     * @param toUserId 对方 id
     */
    public int clear(int type, String toUserId) {
//        ConversationBean conversationBean = mConversationDao.selectByTypeAndToUserId(type, toUserId);
//        if (conversationBean == null) {
//            return 0;
//        }
//        mConversationMessageRelDao.deleteByConversationId(conversationBean.getId());
//        conversationBean.setLastMsgPid(0);
//        conversationBean.setLastMsgContent("");
//        conversationBean.setLastMsgContentType(0);
//        mConversationDao.update(conversationBean);
        return 1;
    }
}
