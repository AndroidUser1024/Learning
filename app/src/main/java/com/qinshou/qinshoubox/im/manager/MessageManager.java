package com.qinshou.qinshoubox.im.manager;

import android.os.Handler;
import android.os.Looper;

import com.jeejio.dbmodule.DatabaseManager;
import com.jeejio.dbmodule.dao.IBaseDao;
import com.jeejio.dbmodule.util.Limit;
import com.jeejio.dbmodule.util.OrderBy;
import com.jeejio.dbmodule.util.Where;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 20:15
 * Description:消息管理者
 */
public class MessageManager {
    private IBaseDao<MessageBean> mMessageDao;
    private IBaseDao<ConversationBean> mConversationDao;
    private IBaseDao<ConversationMessageRelBean> mConversationMessageRelDao;

    public MessageManager() {
        mConversationDao = DatabaseManager.getInstance().getDaoByClass(ConversationBean.class);
        mMessageDao = DatabaseManager.getInstance().getDaoByClass(MessageBean.class);
        mConversationMessageRelDao = DatabaseManager.getInstance().getDaoByClass(ConversationMessageRelBean.class);
    }

    public void save(MessageBean messageBean) {
//        // 插入消息
        mMessageDao.save(messageBean);
    }

    public List<MessageBean> getList(int type, String toUserId, int page, int pageSize) {
        ConversationBean conversationBean = mConversationDao.select(new Where.Builder()
                .equal("toUserId", toUserId)
                .equal("type", type)
                .build());
        if (conversationBean == null) {
            return new ArrayList<>();
        }
        List<Map<String, Object>> list = DatabaseManager.getInstance().rawQuery("SELECT" +
                " m.pid" +
                ",m.id" +
                ",m.fromUserId" +
                ",m.toUserId" +
                ",m.type" +
                ",m.contentType" +
                ",m.content" +
                ",m.sendTimestamp" +
                ",m.receiveTimestamp" +
                ",m.status" +
                ",m.extend" +
                " FROM conversation_message_rel AS cmr" +
                " LEFT OUTER JOIN message AS m ON m.pid=cmr.messagePid" +
                " WHERE" +
                " cmr.conversationId=" + conversationBean.getId() +
                " ORDER BY" +
                " m.pid DESC" +
                " LIMIT" +
                " " + (page - 1) * pageSize + "," + page * pageSize);
        List<MessageBean> messageBeanList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            MessageBean messageBean = new MessageBean();
            messageBean.setPid((int) map.get("pid"));
            messageBean.setId((String) map.get("id"));
            messageBean.setFromUserId((String) map.get("fromUserId"));
            messageBean.setToUserId((String) map.get("toUserId"));
            messageBean.setType((int) map.get("type"));
            messageBean.setContentType((int) map.get("contentType"));
            messageBean.setContent((String) map.get("content"));
            messageBean.setSendTimestamp((long) map.get("sendTimestamp"));
            messageBean.setReceiveTimestamp((long) map.get("receiveTimestamp"));
            messageBean.setStatus((int) map.get("status"));
            messageBean.setExtend((String) map.get("extend"));
            messageBeanList.add(messageBean);
        }
//        Where where = new Where.Builder()
//                .equal("conversationId", conversationBean.getId())
//                .build();
//        OrderBy orderBy = new OrderBy.Builder()
//                .Desc("messagePid")
//                .build();
//        Limit limit = new Limit((page - 1) * pageSize, page * pageSize);
//        List<ConversationMessageRelBean> conversationMessageRelBeanList = mConversationMessageRelDao.selectList(where, orderBy, limit);
        return messageBeanList;
    }

    public MessageBean selectByPid(int pid) {
        return mMessageDao.selectById(pid);
    }
}
