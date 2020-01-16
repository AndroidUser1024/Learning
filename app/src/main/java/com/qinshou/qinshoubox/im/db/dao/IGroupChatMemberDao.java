package com.qinshou.qinshoubox.im.db.dao;

import com.qinshou.qinshoubox.friend.bean.UserDetailBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/16 18:22
 * Description:group_chat_member 表的 Dao
 */
public interface IGroupChatMemberDao extends IBaseDao {
    // 创建表语句
//    String sql = "CREATE TABLE IF NOT EXISTS group_chat_member(" +
//            " group_chat_id TEXT" +
//            ",userId TEXT" +
//            ",nickname TEXT" +
//            ",headImg TEXT" +
//            ",headImgSmall TEXT" +
//            ",remark TEXT" +
//            ",nicknameInGroupChat TEXT" +
//            " )"

    // insert
    int insert(String groupChatId, UserDetailBean userDetailBean);

    int update(String groupChatId, UserDetailBean userDetailBean);

    List<UserDetailBean> selectByGroupChatId(String groupChatId);

    UserDetailBean selectByGroupChatIdAndUserId(String groupChatId, String userId);

    boolean existsByGroupChatIdAndUserId(String groupChatId, String userId);
}
