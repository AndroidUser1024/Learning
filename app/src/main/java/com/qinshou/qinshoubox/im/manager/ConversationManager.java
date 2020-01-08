package com.qinshou.qinshoubox.im.manager;


import android.text.TextUtils;

import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IConversationDao;
import com.qinshou.qinshoubox.im.db.dao.IConversationMessageRelDao;
import com.qinshou.qinshoubox.im.db.dao.IFriendDao;
import com.qinshou.qinshoubox.im.db.dao.IGroupChatDao;
import com.qinshou.qinshoubox.im.db.dao.IMessageDao;
import com.qinshou.qinshoubox.im.enums.MessageType;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/23 8:58
 * Description:会话管理者
 */
public class ConversationManager {
    /**
     * 会话 Dao
     */
    private IConversationDao mConversationDao;
    /**
     * 会话和消息关系 Dao
     */
    private IConversationMessageRelDao mConversationMessageRelDao;
    /**
     * 好友 Dao
     */
    private IFriendDao mFriendDao;
    /**
     * 群 Dao
     */
    private IGroupChatDao mGroupChatDao;

    public ConversationManager(DatabaseHelper databaseHelper, String userId) {
        mConversationDao = databaseHelper.getDao(IConversationDao.class);
        mConversationMessageRelDao = databaseHelper.getDao(IConversationMessageRelDao.class);
        mFriendDao = databaseHelper.getDao(IFriendDao.class);
        mGroupChatDao = databaseHelper.getDao(IGroupChatDao.class);
    }

    public void insertOrUpdate(ConversationBean conversationBean) {
        if (mConversationDao.existsById(conversationBean.getId())) {
            mConversationDao.update(conversationBean);
        } else {
            mConversationDao.insert(conversationBean);
        }
    }

    public void insertConversationMessageRel(ConversationMessageRelBean conversationMessageRelBean) {
        if (!mConversationMessageRelDao.existsByConversationIdAndMessagePid(conversationMessageRelBean)) {
            mConversationMessageRelDao.insert(conversationMessageRelBean);
        }
    }

    public List<ConversationBean> selectList() {
        return mConversationDao.selectList();
    }

    public List<ConversationBean> selectListOrderByLastMsgTimeDesc() {
        return mConversationDao.selectListOrderByLastMsgTimeDesc();
    }

    public List<ConversationBean> selectListOrderByTopDescAndLastMsgTimeDesc() {
        return mConversationDao.selectListOrderByTopDescAndLastMsgTimeDesc();
    }

    public ConversationBean getByTypeAndToUserId(int type, String toUserId) {
        return mConversationDao.selectByTypeAndToUserId(type, toUserId);
    }

    public int getTotalUnreadCount() {
        return mConversationDao.getTotalUnreadCount();
    }

    public void resetUnreadCount(int id) {
        mConversationDao.resetUnreadCount(id);
    }

    public void deleteById(int id) {
        mConversationDao.deleteById(id);
    }

    public void setUnreadCount(int unreadCount, int id) {
        mConversationDao.setUnreadCount(unreadCount, id);
    }
}
