package com.qinshou.qinshoubox.im.db.dao;


import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/2 11:21
 * Description:MessageBean 的 Dao 层
 */
public interface IConversationMessageRelDao {
    int insertOrUpdate(ConversationMessageRelBean conversationMessageRelBean);
}
