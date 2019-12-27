package com.qinshou.qinshoubox.im.db.dao;

import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/04 23:06
 * Description:conversation_message_rel 表的 Dao
 */
public interface IConversationMessageRelDao  extends IBaseDao{
    // 创建表语句
    // CREATE TABLE IF NOT EXISTS conversation_message_rel(
    // id INTEGER PRIMARY KEY AUTOINCREMENT
    // ,conversationId INTEGER,messagePid INTEGER
    // );

    // 插入语句
    // INSERT INTO conversation_message_rel
    // (conversationId,messagePid)
    // VALUES
    // (#{conversationId},#{messagePid});
    void insert(ConversationMessageRelBean conversationMessageRelBean);

    // SELECT
    // COUNT(id)
    // FROM conversation_message_rel
    // WHERE
    // conversationId=#{conversationId} AND messagePid=#{messagePid}
    int existsByConversationIdAndMessagePid(ConversationMessageRelBean conversationMessageRelBean);
}
