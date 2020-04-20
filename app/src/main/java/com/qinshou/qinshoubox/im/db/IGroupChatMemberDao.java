package com.qinshou.qinshoubox.im.db;

import com.qinshou.dbmodule.annotation.Delete;
import com.qinshou.dbmodule.annotation.Param;
import com.qinshou.dbmodule.annotation.Select;
import com.qinshou.dbmodule.dao.IBaseDao;
import com.qinshou.qinshoubox.im.bean.GroupChatMemberBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/17 15:56
 * Description:group_chat_member 表的 Dao
 */
public interface IGroupChatMemberDao extends IBaseDao<GroupChatMemberBean, Integer> {
    @Select("SELECT" +
            " id" +
            ",groupChatId" +
            ",userId" +
            ",nicknameInGroupChat" +
            " FROM group_chat_member" +
            " WHERE" +
            " groupChatId=#{groupChatId}" +
            " AND" +
            " userId=#{userId}")
    GroupChatMemberBean selectByGroupChatIdAndUserId(@Param("groupChatId") String groupChatId, @Param("userId") String userId);

    @Delete("DELETE FROM group_chat_member" +
            " WHERE" +
            " groupChatId=#{groupChatId}" +
            " AND" +
            " userId=#{userId}")
    int deleteByGroupChatIdAndUserId(@Param("groupChatId") String groupChatId, @Param("userId") String userId);
}
