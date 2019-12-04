package com.qinshou.immodule.db.dao;


import com.qinshou.immodule.bean.ConversationBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/2 11:21
 * Description:ConversationBean 的 Dao 层
 */
public interface IConversationDao {
    int insertOrUpdate(ConversationBean conversationBean);

    ConversationBean getByTypeAndToUserId(int type, int toUserId);

    List<ConversationBean> getList();

    int resetUnreadCount(int id);

    int getTotalUnreadCount();
}
