package com.qinshou.immodule.db.dao;


import com.qinshou.immodule.bean.ConversationBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/2 11:21
 * Description:ConversationBean 的 Dao 层
 */
public interface IConversationDao {
    int insertOrUpdate(ConversationBean conversationBean);

    ConversationBean getByToUserId(int toUserId);
}
