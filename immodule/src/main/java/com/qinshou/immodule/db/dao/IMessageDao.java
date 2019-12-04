package com.qinshou.immodule.db.dao;


import com.qinshou.immodule.bean.MessageBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/2 11:21
 * Description:MessageBean 的 Dao 层
 */
public interface IMessageDao {
    int insertOrUpdate(boolean send, MessageBean messageBean);

    List<MessageBean> getList(int conversationId, int page, int pageSize);

    int setStatus(int status,int fromUserId, int toUserId, long sendTimestamp);

    MessageBean getByFromUserIdAndToUserIdAndTypeAndSendTimestamp(int fromUserId, int toUserId, int type, long sendTimestamp);
}
