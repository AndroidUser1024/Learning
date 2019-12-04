package com.qinshou.immodule.db.dao.impl;


import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.db.dao.IConversationMessageRelDao;
import com.qinshou.immodule.db.dao.IMessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/5 17:34
 * Description:MessageDao 的实现类
 */
public class MessageDaoImpl implements IMessageDao {
//    private Dao<MessageBean, Integer> mDao;
    /**
     * 会话与消息关系表 Dao
     */
    private IConversationMessageRelDao mConversationMessageRelDao;

    public MessageDaoImpl() {
//        try {
//            mDao = DBHelper.getInstance().getDao(MessageBean.class);
//            mConversationMessageRelDao = new ConversationMessageRelDaoImpl();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int insertOrUpdate(final boolean send, final MessageBean messageBean) {
//        try {
//            if (mDao.idExists(messageBean.getPid())) {
//                return 0;
//            }
//            TransactionManager transactionManager = new TransactionManager(mDao.getConnectionSource());
//            return transactionManager.callInTransaction(new Callable<Integer>() {
//                @Override
//                public Integer call() throws Exception {
//                    int toUserId;
//                    long lastMsgTime;
//                    if (send) {
//                        toUserId = messageBean.getToUserId();
//                        lastMsgTime = messageBean.getSendTimestamp();
//                    } else {
//                        toUserId = messageBean.getFromUserId();
//                        lastMsgTime = messageBean.getReceiveTimestamp();
//                    }
//                    ConversationBean conversationBean = IMClient.SINGLETON.getConversationManager().getByTypeAndToUserId(messageBean.getType(), toUserId);
//                    if (conversationBean == null) {
//                        conversationBean = new ConversationBean();
//                    }
//                    conversationBean.setToUserId(toUserId);
//                    conversationBean.setType(messageBean.getType());
//                    conversationBean.setLastMsgContent(messageBean.getContent());
//                    conversationBean.setLastMsgContentType(messageBean.getContentType());
//                    conversationBean.setLastMsgTimestamp(lastMsgTime);
//                    if (!send) {
//                        conversationBean.setUnreadCount(conversationBean.getUnreadCount() + 1);
//                    }
//                    IMClient.SINGLETON.getConversationManager().insertOrUpdate(conversationBean);
//
//                    mDao.createOrUpdate(messageBean);
//                    mConversationMessageRelDao.insertOrUpdate(new ConversationMessageRelBean(conversationBean.getId(), messageBean.getPid()));
//                    return 1;
//                }
//            });
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return 0;
    }

    @Override
    public List<MessageBean> getList(int conversationId, int page, int pageSize) {
        List<MessageBean> messageBeanList = new ArrayList<>();
//        try {
//            GenericRawResults<String[]> genericRawResults = mDao.queryRaw("SELECT" +
//                    " message.pid," +
//                    " message.fromUserId," +
//                    " message.toUserId," +
//                    " message.type," +
//                    " message.contentType," +
//                    " message.content," +
//                    " message.sendTimestamp," +
//                    " message.receiveTimestamp," +
//                    " message.status," +
//                    " message.extend" +
//                    " FROM" +
//                    " conversation_message_rel" +
//                    " LEFT OUTER JOIN" +
//                    " message" +
//                    " ON" +
//                    " messageId=message.pid" +
//                    " WHERE conversationId=" + conversationId +
//                    " LIMIT " + page * pageSize + "," + pageSize
//            );
////            String[] columnNames = genericRawResults.getColumnNames();
////            for (String columnName : columnNames) {
////                Log.i("daolema", "columnName--->" + columnName);
////            }
//            List<String[]> results = genericRawResults.getResults();
//            for (int i = 0; i < results.size(); i++) {
//                String[] strings = results.get(i);
//                MessageBean messageBean = new MessageBean();
//                messageBean.setPid(Integer.valueOf(strings[0]));
//                messageBean.setFromUserId(Integer.valueOf(strings[1]));
//                messageBean.setToUserId(Integer.valueOf(strings[2]));
//                messageBean.setType(Integer.valueOf(strings[3]));
//                messageBean.setContentType(Integer.valueOf(strings[4]));
//                messageBean.setContent(strings[5]);
//                messageBean.setSendTimestamp(Long.valueOf(strings[6]));
//                messageBean.setReceiveTimestamp(Long.valueOf(strings[7]));
//                messageBean.setStatus(Integer.valueOf(strings[8]));
//                messageBean.setExtend(strings[9]);
//                messageBeanList.add(messageBean);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return messageBeanList;
    }

    @Override
    public int setStatus(int status, int fromUserId, int toUserId, long sendTimestamp) {
//        try {
//            UpdateBuilder<MessageBean, Integer> updateBuilder = mDao.updateBuilder();
//            updateBuilder.updateColumnValue("status", status)
//                    .where()
//                    .eq("fromUserId", fromUserId)
//                    .and()
//                    .eq("toUserId", toUserId)
//                    .and()
//                    .eq("sendTimestamp", sendTimestamp);
//            return updateBuilder.update();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return 0;
    }

    @Override
    public MessageBean getByFromUserIdAndToUserIdAndTypeAndSendTimestamp(int fromUserId, int toUserId, int type, long sendTimestamp) {
//        try {
//            return mDao.queryBuilder().where().eq("fromUserId", fromUserId)
//                    .and()
//                    .eq("toUserId", toUserId)
//                    .and()
//                    .eq("type", type)
//                    .and()
//                    .eq("sendTimestamp", sendTimestamp)
//                    .queryForFirst();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}