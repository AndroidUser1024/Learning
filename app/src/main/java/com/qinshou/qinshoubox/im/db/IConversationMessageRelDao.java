package com.qinshou.qinshoubox.im.db;

import com.qinshou.dbmodule.annotation.Delete;
import com.qinshou.dbmodule.annotation.Param;
import com.qinshou.dbmodule.annotation.Select;
import com.qinshou.dbmodule.dao.IBaseDao;
import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/17 15:56
 * Description:conversation_message_rel 表的 Dao
 */
public interface IConversationMessageRelDao extends IBaseDao<ConversationMessageRelBean, Integer> {
    @Select("SELECT" +
            " COUNT(id) count" +
            " FROM conversation_message_rel" +
            " WHERE" +
            " conversationId=#{conversationId}" +
            " AND" +
            " messagePid=#{messagePid}")
    int existsByConversationIdAndMessagePid(@Param("conversationId") int conversationId
            , @Param("messagePid") int messagePid);

    @Delete("DELETE FROM conversation_message_rel" +
            " WHERE" +
            " conversation=#{conversationId}")
    int deleteByConversationId(@Param("conversationId") int conversationId);
}
