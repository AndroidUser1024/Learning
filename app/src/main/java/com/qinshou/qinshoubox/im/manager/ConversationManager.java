package com.qinshou.qinshoubox.im.manager;


import android.text.TextUtils;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.jeejio.dbmodule.DatabaseManager;
import com.jeejio.dbmodule.dao.IBaseDao;
import com.jeejio.dbmodule.util.OrderBy;
import com.jeejio.dbmodule.util.Where;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.MessageType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public List<ConversationBean> getList() {
        List<Map<String, Object>> list = DatabaseManager.getInstance().rawQuery("SELECT" +
                " c.id" +
                ",c.unreadCount" +
                ",c.type" +
                ",c.toUserId" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",m.content" +
                ",m.contentType" +
                ",m.status" +
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
                " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001");
        List<ConversationBean> conversationBeanList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            ConversationBean conversationBean = new ConversationBean();
            conversationBean.setId((int) map.get("id"));
            conversationBean.setUnreadCount((int) map.get("unreadCount"));
            conversationBean.setType((int) map.get("type"));
            conversationBean.setToUserId((String) map.get("toUserId"));
            conversationBean.setLastMsgTimestamp((long) map.get("lastMsgTimestamp_Long"));
            conversationBean.setLastMsgPid((int) map.get("lastMsgPid"));
            conversationBean.setLastMsgContent((String) map.get("content"));
            conversationBean.setLastMsgContentType((int) map.get("contentType"));
            conversationBean.setLastMsgStatus((int) map.get("status"));

            if (conversationBean.getType() == MessageType.CHAT.getValue()) {
                conversationBean.setHeadImgSmall((String) map.get("uHeadImgSmall"));
                conversationBean.setTop((int) map.get("fTop"));
                conversationBean.setDoNotDisturb((int) map.get("fDoNotDisturb"));
                String remark = (String) map.get("fRemark");
                if (TextUtils.isEmpty(remark)) {
                    conversationBean.setTitle((String) map.get("uNickname"));
                } else {
                    conversationBean.setTitle(remark);
                }
            } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                conversationBean.setHeadImgSmall((String) map.get("gcHeadImgSmall"));
                conversationBean.setTop((int) map.get("gcTop"));
                conversationBean.setDoNotDisturb((int) map.get("gcDoNotDisturb"));
                String groupChatNickname = (String) map.get("gcNickname");
                if (TextUtils.isEmpty(groupChatNickname)) {
                    conversationBean.setTitle((String) map.get("gcNicknameDefault"));
                } else {
                    conversationBean.setTitle(groupChatNickname);
                }
            }
            conversationBeanList.add(conversationBean);
        }
        return conversationBeanList;
    }

    public List<ConversationBean> getListOrderByLastMsgTimeDesc() {
        List<Map<String, Object>> list = DatabaseManager.getInstance().rawQuery("SELECT" +
                " c.id" +
                ",c.unreadCount" +
                ",c.type" +
                ",c.toUserId" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",m.content" +
                ",m.contentType" +
                ",m.status" +
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
                " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
                " ORDER BY c.lastMsgTimestamp DESC");
        List<ConversationBean> conversationBeanList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            ConversationBean conversationBean = new ConversationBean();
            conversationBean.setId((int) map.get("id"));
            conversationBean.setUnreadCount((int) map.get("unreadCount"));
            conversationBean.setType((int) map.get("type"));
            conversationBean.setToUserId((String) map.get("toUserId"));
            conversationBean.setLastMsgTimestamp((long) map.get("lastMsgTimestamp_Long"));
            conversationBean.setLastMsgPid((int) map.get("lastMsgPid"));
            conversationBean.setLastMsgContent((String) map.get("content"));
            conversationBean.setLastMsgContentType((int) map.get("contentType"));
            conversationBean.setLastMsgStatus((int) map.get("status"));

            if (conversationBean.getType() == MessageType.CHAT.getValue()) {
                conversationBean.setHeadImgSmall((String) map.get("uHeadImgSmall"));
                conversationBean.setTop((int) map.get("fTop"));
                conversationBean.setDoNotDisturb((int) map.get("fDoNotDisturb"));
                String remark = (String) map.get("fRemark");
                if (TextUtils.isEmpty(remark)) {
                    conversationBean.setTitle((String) map.get("uNickname"));
                } else {
                    conversationBean.setTitle(remark);
                }
            } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                conversationBean.setHeadImgSmall((String) map.get("gcHeadImgSmall"));
                conversationBean.setTop((int) map.get("gcTop"));
                conversationBean.setDoNotDisturb((int) map.get("gcDoNotDisturb"));
                String groupChatNickname = (String) map.get("gcNickname");
                if (TextUtils.isEmpty(groupChatNickname)) {
                    conversationBean.setTitle((String) map.get("gcNicknameDefault"));
                } else {
                    conversationBean.setTitle(groupChatNickname);
                }
            }
            conversationBeanList.add(conversationBean);
        }
        return conversationBeanList;
    }

    public List<ConversationBean> getListOrderByTopDescAndLastMsgTimeDesc() {
        List<Map<String, Object>> list = DatabaseManager.getInstance().rawQuery("SELECT" +
                " c.id" +
                ",c.unreadCount" +
                ",c.type" +
                ",c.toUserId" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",m.content" +
                ",m.contentType" +
                ",m.status" +
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
                " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
                " ORDER BY" +
                " fTop DESC" +
                ",gcTop DESC" +
                ",c.lastMsgTimestamp DESC");
        List<ConversationBean> conversationBeanList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            ConversationBean conversationBean = new ConversationBean();
            conversationBean.setId((int) map.get("id"));
            conversationBean.setUnreadCount((int) map.get("unreadCount"));
            conversationBean.setType((int) map.get("type"));
            conversationBean.setToUserId((String) map.get("toUserId"));
            conversationBean.setLastMsgTimestamp((long) map.get("lastMsgTimestamp_Long"));
            conversationBean.setLastMsgPid((int) map.get("lastMsgPid"));
            conversationBean.setLastMsgContent((String) map.get("content"));
            conversationBean.setLastMsgContentType((int) map.get("contentType"));
            conversationBean.setLastMsgStatus((int) map.get("status"));

            if (conversationBean.getType() == MessageType.CHAT.getValue()) {
                conversationBean.setHeadImgSmall((String) map.get("uHeadImgSmall"));
                conversationBean.setTop((int) map.get("fTop"));
                conversationBean.setDoNotDisturb((int) map.get("fDoNotDisturb"));
                String remark = (String) map.get("fRemark");
                if (TextUtils.isEmpty(remark)) {
                    conversationBean.setTitle((String) map.get("uNickname"));
                } else {
                    conversationBean.setTitle(remark);
                }
            } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                conversationBean.setHeadImgSmall((String) map.get("gcHeadImgSmall"));
                conversationBean.setTop((int) map.get("gcTop"));
                conversationBean.setDoNotDisturb((int) map.get("gcDoNotDisturb"));
                String groupChatNickname = (String) map.get("gcNickname");
                if (TextUtils.isEmpty(groupChatNickname)) {
                    conversationBean.setTitle((String) map.get("gcNicknameDefault"));
                } else {
                    conversationBean.setTitle(groupChatNickname);
                }
            }
            conversationBeanList.add(conversationBean);
        }
        return conversationBeanList;
    }

    public ConversationBean selectById(int id) {
        List<Map<String, Object>> list = DatabaseManager.getInstance().rawQuery("SELECT" +
                " c.id" +
                ",c.unreadCount" +
                ",c.type" +
                ",c.toUserId" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",m.content" +
                ",m.contentType" +
                ",m.status" +
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
                " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
                " WHERE" +
                " c.id=" + id);
        ConversationBean conversationBean = new ConversationBean();
        if (list.size() > 0) {
            Map<String, Object> map = list.get(0);

            conversationBean.setId((int) map.get("id"));
            conversationBean.setUnreadCount((int) map.get("unreadCount"));
            conversationBean.setType((int) map.get("type"));
            conversationBean.setToUserId((String) map.get("toUserId"));
            conversationBean.setLastMsgTimestamp((long) map.get("lastMsgTimestamp_Long"));
            conversationBean.setLastMsgPid((int) map.get("lastMsgPid"));
            conversationBean.setLastMsgContent((String) map.get("content"));
            conversationBean.setLastMsgContentType((int) map.get("contentType"));
            conversationBean.setLastMsgStatus((int) map.get("status"));

            if (conversationBean.getType() == MessageType.CHAT.getValue()) {
                conversationBean.setHeadImgSmall((String) map.get("uHeadImgSmall"));
                conversationBean.setTop((int) map.get("fTop"));
                conversationBean.setDoNotDisturb((int) map.get("fDoNotDisturb"));
                String remark = (String) map.get("fRemark");
                if (TextUtils.isEmpty(remark)) {
                    conversationBean.setTitle((String) map.get("uNickname"));
                } else {
                    conversationBean.setTitle(remark);
                }
            } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                conversationBean.setHeadImgSmall((String) map.get("gcHeadImgSmall"));
                conversationBean.setTop((int) map.get("gcTop"));
                conversationBean.setDoNotDisturb((int) map.get("gcDoNotDisturb"));
                String groupChatNickname = (String) map.get("gcNickname");
                if (TextUtils.isEmpty(groupChatNickname)) {
                    conversationBean.setTitle((String) map.get("gcNicknameDefault"));
                } else {
                    conversationBean.setTitle(groupChatNickname);
                }
            }
        }
        return conversationBean;
    }

    public ConversationBean getByTypeAndToUserId(int type, String toUserId) {
        List<Map<String, Object>> list = DatabaseManager.getInstance().rawQuery("SELECT" +
                " c.id" +
                ",c.unreadCount" +
                ",c.type" +
                ",c.toUserId" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",m.content" +
                ",m.contentType" +
                ",m.status" +
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
                " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
                " WHERE" +
                " c.type=" + type +
                " AND" +
                " c.toUserId=\"" + toUserId + "\"");
        ConversationBean conversationBean = new ConversationBean();
        ShowLogUtil.logi("list--->" + list);
        if (list.size() > 0) {
            Map<String, Object> map = list.get(0);
            ShowLogUtil.logi("map--->" + map);

            conversationBean.setId((int) map.get("id"));
            conversationBean.setUnreadCount((int) map.get("unreadCount"));
            conversationBean.setType((int) map.get("type"));
            conversationBean.setToUserId((String) map.get("toUserId"));
            conversationBean.setLastMsgTimestamp((long) map.get("lastMsgTimestamp_Long"));
            conversationBean.setLastMsgPid((int) map.get("lastMsgPid"));
            conversationBean.setLastMsgContent((String) map.get("content"));
            conversationBean.setLastMsgContentType((int) map.get("contentType"));
            conversationBean.setLastMsgStatus((int) map.get("status"));

            if (conversationBean.getType() == MessageType.CHAT.getValue()) {
                conversationBean.setHeadImgSmall((String) map.get("uHeadImgSmall"));
                conversationBean.setTop((int) map.get("fTop"));
                conversationBean.setDoNotDisturb((int) map.get("fDoNotDisturb"));
                String remark = (String) map.get("fRemark");
                if (TextUtils.isEmpty(remark)) {
                    conversationBean.setTitle((String) map.get("uNickname"));
                } else {
                    conversationBean.setTitle(remark);
                }
            } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                conversationBean.setHeadImgSmall((String) map.get("gcHeadImgSmall"));
                conversationBean.setTop((int) map.get("gcTop"));
                conversationBean.setDoNotDisturb((int) map.get("gcDoNotDisturb"));
                String groupChatNickname = (String) map.get("gcNickname");
                if (TextUtils.isEmpty(groupChatNickname)) {
                    conversationBean.setTitle((String) map.get("gcNicknameDefault"));
                } else {
                    conversationBean.setTitle(groupChatNickname);
                }
            }
        }
        return conversationBean;
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
