package com.qinshou.qinshoubox.im.db;

import com.qinshou.dbmodule.annotation.Param;
import com.qinshou.dbmodule.annotation.Select;
import com.qinshou.dbmodule.dao.IBaseDao;
import com.qinshou.qinshoubox.im.bean.MessageBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/17 15:56
 * Description:message 表的 Dao
 */
public interface IMessageDao extends IBaseDao<MessageBean, Integer> {
    @Select("SELECT" +
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
            " c.type=#{type}" +
            " AND" +
            " c.toUserId=#{toUserId}" +
            " ORDER BY" +
            " m.pid DESC" +
            " LIMIT #{start},#{size}")
    List<MessageBean> selectList(@Param("type") int type
            , @Param("toUserId") String toUserId
            , @Param("start") int start
            , @Param("size") int size);
}
