package com.qinshou.immodule.db.dao.impl;

import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.db.dao.IConversationDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/5 17:34
 * Description:ConversationDao 的实现类
 */
public class ConversationDaoImpl implements IConversationDao {
//    private Dao<ConversationBean, Integer> mDao;

    public ConversationDaoImpl() {
//        try {
//            mDao = DBHelper.getInstance().getDao(ConversationBean.class);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int insertOrUpdate(ConversationBean conversationBean) {
//        try {
//            return mDao.createOrUpdate(conversationBean).getNumLinesChanged();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return 0;
    }

    @Override
    public ConversationBean getByTypeAndToUserId(int type, int toUserId) {
//        try {
//            GenericRawResults<String[]> genericRawResults = mDao.queryRaw("SELECT" +
//                    " conversation.id," +
//                    " conversation.toUserId," +
//                    " conversation.type," +
//                    " conversation.lastMsgContent," +
//                    " conversation.lastMsgContentType," +
//                    " conversation.lastMsgTimestamp ," +
//                    " conversation.unreadCount," +
//                    " friend.headImgSmall," +
//                    " friend.nickname," +
//                    " friend.remark," +
//                    " group_chat.headImgSmall," +
//                    " group_chat.nickname," +
//                    " group_chat.nicknameDefault" +
//                    " FROM" +
//                    " conversation" +
//                    " LEFT OUTER JOIN" +
//                    " friend" +
//                    " ON conversation.type=2001 AND conversation.toUserId=friend.id" +
//                    " LEFT OUTER JOIN" +
//                    " group_chat" +
//                    " ON conversation.type=3001 AND conversation.toUserId=group_chat.id" +
//                    " WHERE" +
//                    " conversation.toUserId=" + toUserId +
//                    " ORDER BY " +
//                    " conversation.lastMsgTimestamp DESC"
//            );
////            String[] columnNames = genericRawResults.getColumnNames();
////            for (String columnName : columnNames) {
////                Log.i("daolema", "columnName--->" + columnName);
////            }
//            String[] firstResult = genericRawResults.getFirstResult();
//            if (firstResult == null) {
//                return null;
//            }
//            ConversationBean conversationBean = new ConversationBean();
//            conversationBean.setId(Integer.valueOf(firstResult[0]));
//            conversationBean.setToUserId(Integer.valueOf(firstResult[1]));
//            conversationBean.setType(Integer.valueOf(firstResult[2]));
//            conversationBean.setLastMsgContent(firstResult[3]);
//            conversationBean.setLastMsgContentType(Integer.valueOf(firstResult[4]));
//            conversationBean.setLastMsgTimestamp(Long.valueOf(firstResult[5]));
//            conversationBean.setUnreadCount(Integer.valueOf(firstResult[6]));
//            if (conversationBean.getType() == MessageType.CHAT.getValue()) {
//                // 单聊头像
//                conversationBean.setHeadImgSmall(firstResult[7]);
//                // 备注为空,则会话标题设置为用户昵称,否则设置为备注
//                conversationBean.setTitle(TextUtils.isEmpty(firstResult[9])
//                        ? firstResult[8]
//                        : firstResult[9]);
//            } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
//                // 群聊头像
//                conversationBean.setHeadImgSmall(firstResult[10]);
//                // 群昵称为空,则会话标题设置为群默认昵称,否则设置为昵称
//                conversationBean.setTitle(TextUtils.isEmpty(firstResult[11])
//                        ? firstResult[12]
//                        : firstResult[11]);
//            }
//            return conversationBean;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public List<ConversationBean> getList() {
        List<ConversationBean> conversationBeanList = new ArrayList<>();
//        try {
//            GenericRawResults<String[]> genericRawResults = mDao.queryRaw("SELECT" +
//                    " conversation.id," +
//                    " conversation.toUserId," +
//                    " conversation.type," +
//                    " conversation.lastMsgContent," +
//                    " conversation.lastMsgContentType," +
//                    " conversation.lastMsgTimestamp ," +
//                    " conversation.unreadCount," +
//                    " friend.headImgSmall," +
//                    " friend.nickname," +
//                    " friend.remark," +
//                    " group_chat.headImgSmall," +
//                    " group_chat.nickname," +
//                    " group_chat.nicknameDefault" +
//                    " FROM" +
//                    " conversation" +
//                    " LEFT OUTER JOIN" +
//                    " friend" +
//                    " ON conversation.type=2001 AND conversation.toUserId=friend.id" +
//                    " LEFT OUTER JOIN" +
//                    " group_chat" +
//                    " ON conversation.type=3001 AND conversation.toUserId=group_chat.id" +
//                    " ORDER BY " +
//                    " conversation.lastMsgTimestamp DESC"
//            );
////            String[] columnNames = genericRawResults.getColumnNames();
////            for (String columnName : columnNames) {
////                Log.i("daolema", "columnName--->" + columnName);
////            }
//            List<String[]> results = genericRawResults.getResults();
//            for (int i = 0; i < results.size(); i++) {
//                String[] strings = results.get(i);
//                ConversationBean conversationBean = new ConversationBean();
//                conversationBean.setId(Integer.valueOf(strings[0]));
//                conversationBean.setToUserId(Integer.valueOf(strings[1]));
//                conversationBean.setType(Integer.valueOf(strings[2]));
//                conversationBean.setLastMsgContent(strings[3]);
//                conversationBean.setLastMsgContentType(Integer.valueOf(strings[4]));
//                conversationBean.setLastMsgTimestamp(Long.valueOf(strings[5]));
//                conversationBean.setUnreadCount(Integer.valueOf(strings[6]));
//                if (conversationBean.getType() == MessageType.CHAT.getValue()) {
//                    // 单聊头像
//                    conversationBean.setHeadImgSmall(strings[7]);
//                    // 备注为空,则会话标题设置为用户昵称,否则设置为备注
//                    conversationBean.setTitle(TextUtils.isEmpty(strings[9])
//                            ? strings[8]
//                            : strings[9]);
//                } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
//                    // 群聊头像
//                    conversationBean.setHeadImgSmall(strings[10]);
//                    // 群昵称为空,则会话标题设置为群默认昵称,否则设置为昵称
//                    conversationBean.setTitle(TextUtils.isEmpty(strings[11])
//                            ? strings[12]
//                            : strings[11]);
//                }
//                conversationBeanList.add(conversationBean);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return conversationBeanList;
    }


    @Override
    public int resetUnreadCount(int id) {
//        try {
//            UpdateBuilder<ConversationBean, Integer> updateBuilder = mDao.updateBuilder();
//            updateBuilder.updateColumnValue("unreadCount", 0)
//                    .where().eq("id", id);
//            return updateBuilder.update();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return 0;
    }

    @Override
    public int getTotalUnreadCount() {
//        try {
//            GenericRawResults<String[]> genericRawResults = mDao.queryRaw("SELECT SUM(unreadCount) FROM conversation");
//            String[] firstResult = genericRawResults.getFirstResult();
//            if (firstResult == null || firstResult.length == 0 || TextUtils.isEmpty(firstResult[0])) {
//                return 0;
//            }
//            return Integer.valueOf(firstResult[0]);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return 0;
    }
}
