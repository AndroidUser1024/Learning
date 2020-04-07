package com.qinshou.qinshoubox.im.manager;


import android.text.TextUtils;

import com.jeejio.dbmodule.DatabaseManager;
import com.jeejio.dbmodule.dao.IBaseDao;
import com.jeejio.dbmodule.condition.Where;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.ConversationDetailBean;
import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.MessageType;

import java.util.ArrayList;
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
        mConversationDao.deleteById(id);
    }

    public List<ConversationDetailBean> getList() {
        String sql = "SELECT" +
                " c.id" +
                ",c.unreadCount" +
                ",c.type" +
                ",c.toUserId" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",m.content AS lastMsgContent" +
                ",m.contentType AS lastMsgContentType" +
                ",m.status AS lastMsgStatus" +
                ",u.nickname AS uNickname" +
                ",u.headImgSmall AS uHeadImgSmall" +
                ",f.remark AS fRemark" +
                ",f.top AS fTop" +
                ",f.doNotDisturb AS fDoNotDisturb" +
                ",gc.nickname AS gcNickname" +
                ",gc.headImgSmall AS gcHeadImgSmall" +
                ",gc.nicknameDefault AS gcNicknameDefault" +
                ",gc.top AS gcTop" +
                ",gc.doNotDisturb AS gcDoNotDisturb" +
                " FROM conversation AS c" +
                " LEFT OUTER JOIN message AS m ON m.pid=c.lastMsgPid" +
                " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=" + MessageType.CHAT.getValue() +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=" + MessageType.CHAT.getValue() +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=" + MessageType.GROUP_CHAT.getValue();
        return DatabaseManager.getInstance().rawQueryList(sql, ConversationDetailBean.class);
    }

    public List<ConversationDetailBean> getListOrderByLastMsgTimeDesc() {
        String sql = "SELECT" +
                " c.id" +
                ",c.unreadCount" +
                ",c.type" +
                ",c.toUserId" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",m.content AS lastMsgContent" +
                ",m.contentType AS lastMsgContentType" +
                ",m.status AS lastMsgStatus" +
                ",u.nickname AS uNickname" +
                ",u.headImgSmall AS uHeadImgSmall" +
                ",f.remark AS fRemark" +
                ",f.top AS fTop" +
                ",f.doNotDisturb AS fDoNotDisturb" +
                ",gc.nickname AS gcNickname" +
                ",gc.headImgSmall AS gcHeadImgSmall" +
                ",gc.nicknameDefault AS gcNicknameDefault" +
                ",gc.top AS gcTop" +
                ",gc.doNotDisturb AS gcDoNotDisturb" +
                " FROM conversation AS c" +
                " LEFT OUTER JOIN message AS m ON m.pid=c.lastMsgPid" +
                " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=" + MessageType.CHAT.getValue() +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=" + MessageType.CHAT.getValue() +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=" + MessageType.GROUP_CHAT.getValue() +
                " ORDER BY c.lastMsgTimestamp DESC";
        return DatabaseManager.getInstance().rawQueryList(sql, ConversationDetailBean.class);
    }

    public List<ConversationDetailBean> getListOrderByTopDescAndLastMsgTimeDesc() {
        String sql = "SELECT" +
                " c.id" +
                ",c.unreadCount" +
                ",c.type" +
                ",c.toUserId" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",m.content AS lastMsgContent" +
                ",m.contentType AS lastMsgContentType" +
                ",m.status AS lastMsgStatus" +
                ",u.nickname AS uNickname" +
                ",u.headImgSmall AS uHeadImgSmall" +
                ",f.remark AS fRemark" +
                ",f.top AS fTop" +
                ",f.doNotDisturb AS fDoNotDisturb" +
                ",gc.nickname AS gcNickname" +
                ",gc.headImgSmall AS gcHeadImgSmall" +
                ",gc.nicknameDefault AS gcNicknameDefault" +
                ",gc.top AS gcTop" +
                ",gc.doNotDisturb AS gcDoNotDisturb" +
                " FROM conversation AS c" +
                " LEFT OUTER JOIN message AS m ON m.pid=c.lastMsgPid" +
                " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=" + MessageType.CHAT.getValue() +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=" + MessageType.CHAT.getValue() +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=" + MessageType.GROUP_CHAT.getValue() +
                " ORDER BY" +
                " fTop OR gcTop DESC" +
                ",c.lastMsgTimestamp DESC";
        return DatabaseManager.getInstance().rawQueryList(sql, ConversationDetailBean.class);
    }

    public ConversationDetailBean selectById(int id) {
        String sql = "SELECT" +
                " c.id" +
                ",c.unreadCount" +
                ",c.type" +
                ",c.toUserId" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",m.content AS lastMsgContent" +
                ",m.contentType AS lastMsgContentType" +
                ",m.status AS lastMsgStatus" +
                ",u.nickname AS uNickname" +
                ",u.headImgSmall AS uHeadImgSmall" +
                ",f.remark AS fRemark" +
                ",f.top AS fTop" +
                ",f.doNotDisturb AS fDoNotDisturb" +
                ",gc.nickname AS gcNickname" +
                ",gc.headImgSmall AS gcHeadImgSmall" +
                ",gc.nicknameDefault AS gcNicknameDefault" +
                ",gc.top AS gcTop" +
                ",gc.doNotDisturb AS gcDoNotDisturb" +
                " FROM conversation AS c" +
                " LEFT OUTER JOIN message AS m ON m.pid=c.lastMsgPid" +
                " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=" + MessageType.CHAT.getValue() +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=" + MessageType.CHAT.getValue() +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=" + MessageType.GROUP_CHAT.getValue() +
                " WHERE" +
                " c.id=" + id;
        return DatabaseManager.getInstance().rawQuery(sql, ConversationDetailBean.class);
    }

    public ConversationDetailBean selectDetailByTypeAndToUserId(int type, String toUserId) {
        String sql = "SELECT" +
                " c.id" +
                ",c.unreadCount" +
                ",c.type" +
                ",c.toUserId" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",m.content AS lastMsgContent" +
                ",m.contentType AS lastMsgContentType" +
                ",m.status AS lastMsgStatus" +
                ",u.nickname AS uNickname" +
                ",u.headImgSmall AS uHeadImgSmall" +
                ",f.remark AS fRemark" +
                ",f.top AS fTop" +
                ",f.doNotDisturb AS fDoNotDisturb" +
                ",gc.nickname AS gcNickname" +
                ",gc.headImgSmall AS gcHeadImgSmall" +
                ",gc.nicknameDefault AS gcNicknameDefault" +
                ",gc.top AS gcTop" +
                ",gc.doNotDisturb AS gcDoNotDisturb" +
                " FROM conversation AS c" +
                " LEFT OUTER JOIN message AS m ON m.pid=c.lastMsgPid" +
                " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=" + MessageType.CHAT.getValue() +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=" + MessageType.CHAT.getValue() +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=" + MessageType.GROUP_CHAT.getValue() +
                " WHERE" +
                " c.type=" + type +
                " AND" +
                " c.toUserId=\'" + toUserId + "\'";
        return DatabaseManager.getInstance().rawQuery(sql, ConversationDetailBean.class);
    }

    public ConversationBean selectByTypeAndToUserId(int type, String toUserId) {
        return mConversationDao.select(new Where.Builder()
                .equal("type", type)
                .and()
                .equal("toUserId", toUserId)
                .build());
    }

    public int getTotalUnreadCount() {
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
                .and()
                .equal("type", type)
                .build());
        if (conversationBean == null) {
            return 0;
        }
        conversationBean.setLastMsgPid(0);
        mConversationDao.update(conversationBean);
        mConversationMessageRelDao.delete(new Where.Builder()
                .equal("conversationId", conversationBean.getId())
                .build());
        return 1;
    }
}
