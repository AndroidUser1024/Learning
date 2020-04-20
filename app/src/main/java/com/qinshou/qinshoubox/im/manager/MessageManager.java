package com.qinshou.qinshoubox.im.manager;

import com.qinshou.dbmodule.DatabaseManager;
import com.qinshou.dbmodule.dao.IBaseDao;
import com.qinshou.qinshoubox.im.bean.MessageBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 20:15
 * Description:消息管理者
 */
public class MessageManager {
    private IBaseDao<MessageBean> mMessageDao;

    public MessageManager() {
        mMessageDao = DatabaseManager.getInstance().getDaoByClass(MessageBean.class);
    }

    public void save(MessageBean messageBean) {
//        // 插入消息
        mMessageDao.save(messageBean);
    }

    public List<MessageBean> getList(int type, String toUserId, int page, int pageSize) {
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
                " FROM conversation AS c" +
                " INNER JOIN conversation_message_rel AS cmr ON cmr.conversationId=c.id" +
                " INNER JOIN message AS m ON m.pid=cmr.messagePid" +
                " WHERE" +
                " c.type=" + type +
                " AND" +
                " c.toUserId=\'" + toUserId +"\'"+
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
            messageBean.setSendTimestamp((long) map.get("sendTimestamp_Long"));
            messageBean.setReceiveTimestamp((long) map.get("receiveTimestamp_Long"));
            messageBean.setStatus((int) map.get("status"));
            messageBean.setExtend((String) map.get("extend"));
            messageBeanList.add(messageBean);
        }
        return messageBeanList;
    }

    public MessageBean selectByPid(int pid) {
        return mMessageDao.selectById(pid);
    }
}
