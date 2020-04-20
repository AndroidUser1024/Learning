package com.qinshou.qinshoubox.im.manager;


import com.qinshou.dbmodule.DatabaseManager;
import com.qinshou.dbmodule.condition.Where;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.ConversationDetailBean;
import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;
import com.qinshou.qinshoubox.im.db.IConversationDao;
import com.qinshou.qinshoubox.im.db.IConversationMessageRelDao;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/23 8:58
 * Description:会话管理者
 */
public class ConversationManager {
    private IConversationDao mConversationDao;
    private IConversationMessageRelDao mConversationMessageRelDao;

    public ConversationManager() {
        mConversationDao = DatabaseManager.getInstance().getDao(IConversationDao.class);
        mConversationMessageRelDao = DatabaseManager.getInstance().getDao(IConversationMessageRelDao.class);
    }

    public void save(ConversationBean conversationBean) {
        if (mConversationDao.existsById(conversationBean.getId()) == 0) {
            mConversationDao.insert(conversationBean);
        } else {
            mConversationDao.updateById(conversationBean);
        }
    }

    public void insertConversationMessageRel(ConversationMessageRelBean conversationMessageRelBean) {
        if (mConversationMessageRelDao.existsByConversationIdAndMessagePid(conversationMessageRelBean.getConversationId()
                , conversationMessageRelBean.getMessagePid()) == 0) {
            mConversationMessageRelDao.insert(conversationMessageRelBean);
        }
    }

    public void deleteById(int id) {
        mConversationDao.deleteById(id);
    }

    public List<ConversationDetailBean> getList() {
        return mConversationDao.getList();
    }

    public List<ConversationDetailBean> getListOrderByLastMsgTimeDesc() {
        return mConversationDao.getListOrderByLastMsgTimeDesc();
    }

    public List<ConversationDetailBean> getListOrderByTopDescAndLastMsgTimeDesc() {
        return mConversationDao.getListOrderByTopDescAndLastMsgTimeDesc();
    }

    public ConversationDetailBean selectById(int id) {
        return mConversationDao.selectDetailById(id);
    }

    public ConversationDetailBean selectDetailByTypeAndToUserId(int type, String toUserId) {
        return mConversationDao.selectDetailByTypeAndToUserId(type, toUserId);
    }

    public ConversationBean selectByTypeAndToUserId(int type, String toUserId) {
        return mConversationDao.selectByTypeAndToUserId(type, toUserId);
    }

    public int getTotalUnreadCount() {
        return mConversationDao.getTotalUnreadCount();
    }

    public void setUnreadCount(int unreadCount, int id) {
        ConversationBean conversationBean = mConversationDao.selectById(id);
        if (conversationBean == null) {
            return;
        }
        conversationBean.setUnreadCount(unreadCount);
        mConversationDao.updateById(conversationBean);
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
        ConversationBean conversationBean = mConversationDao.selectByTypeAndToUserId(type, toUserId);
        if (conversationBean == null) {
            return 0;
        }
        conversationBean.setLastMsgPid(0);
        mConversationDao.updateById(conversationBean);
        mConversationMessageRelDao.deleteByConversationId(conversationBean.getId());
        return 1;
    }
}
