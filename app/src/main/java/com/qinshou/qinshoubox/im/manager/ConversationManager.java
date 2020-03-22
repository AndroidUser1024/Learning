package com.qinshou.qinshoubox.im.manager;


import com.jeejio.dbmodule.DatabaseManager;
import com.jeejio.dbmodule.dao.IBaseDao;
import com.jeejio.dbmodule.util.OrderBy;
import com.jeejio.dbmodule.util.Where;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;

import java.util.List;
import java.util.Map;

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

    public void save(ConversationBean conversationBean) {
        mConversationDao.save(conversationBean);
    }

    public void insertConversationMessageRel(ConversationMessageRelBean conversationMessageRelBean) {
        List<Map<String, Object>> list = DatabaseManager.getInstance().rawQuery("SELECT" +
                " COUNT(id) count" +
                " FROM conversation_message_rel" +
                " WHERE" +
                " conversationId=" + conversationMessageRelBean.getConversationId() +
                " AND" +
                " messagePid=" + conversationMessageRelBean.getMessagePid());
        if (list.size() > 0) {
            Object count = list.get(0).get("count");
            if (count instanceof Integer && (int) count == 0) {
                mConversationMessageRelDao.insert(conversationMessageRelBean);
            }
        }
    }

    public void deleteById(int id) {
//        mConversationDao.deleteById(id);
    }

    public List<ConversationBean> getList() {
        return mConversationDao.selectList();
    }

    public List<ConversationBean> getListOrderByLastMsgTimeDesc() {
        return mConversationDao.selectList();
    }

    public List<ConversationBean> getListOrderByTopDescAndLastMsgTimeDesc() {
//        return mConversationDao.selectListOrderByTopDescAndLastMsgTimeDesc();
        return mConversationDao.selectList();
    }

    public ConversationBean getByTypeAndToUserId(int type, String toUserId) {
//        return mConversationDao.selectByTypeAndToUserId(type, toUserId);
        return null;
    }

    public int getTotalUnreadCount() {
//        return mConversationDao.getTotalUnreadCount();
        List<Map<String, Object>> list = DatabaseManager.getInstance().rawQuery("SELECT" +
                " SUM(ABS(unreadCount)) AS totalUnreadCount" +
                " FROM conversation AS c" +
                " WHERE" +
                " (SELECT doNotDisturb FROM friend AS f WHERE c.type=2001 AND f.id=c.toUserId)=0" +
                " OR" +
                " (SELECT doNotDisturb FROM group_chat AS gc WHERE c.type=3001 AND gc.id=c.toUserId)=0");
        if (list.size() > 0) {
            Object totalUnreadCount = list.get(0).get("totalUnreadCount");
            if (totalUnreadCount instanceof Integer) {
                return (int) totalUnreadCount;
            }
        }
        return 0;
    }

    public void setUnreadCount(int unreadCount, int id) {
        ConversationBean conversationBean = mConversationDao.selectById(id);
        if (conversationBean == null) {
            return;
        }
        conversationBean.setUnreadCount(unreadCount);
        mConversationDao.update(conversationBean);
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
        ConversationBean conversationBean = mConversationDao.select(new Where.Builder()
                .equal("toUserId", toUserId)
                .equal("type", type)
                .build());
        if (conversationBean == null) {
            return 0;
        }
        mConversationMessageRelDao.delete(new Where.Builder()
                .equal("conversationId", conversationBean.getId())
                .build());
        return 1;
    }
}
