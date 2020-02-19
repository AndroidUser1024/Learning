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
//            " groupChatId TEXT" +
//            ",userId TEXT" +
//            ",nickname TEXT" +
//            ",headImg TEXT" +
//            ",headImgSmall TEXT" +
//            ",nicknameInGroupChat TEXT" +
//            " )"

    // insert
//    String sql = "INSERT INTO group_chat_member" +
//            " (" +
//            "groupChatId" +
//            ",userId" +
//            ",nickname" +
//            ",headImg" +
//            ",headImgSmall" +
//            ",nicknameInGroupChat" +
//            ")" +
//            " VALUES" +
//            " (" +
//            "%s" +
//            ",%s" +
//            ",%s" +
//            ",%s" +
//            ",%s" +
//            ",%s" +
//            ")";
    int insert(String groupChatId, UserDetailBean userDetailBean);

    // update
//    String sql = "UPDATE group_chat_member SET" +
//            " nickname=%s" +
//            ",headImg=%s" +
//            ",headImgSmall=%s" +
//            ",nicknameInGroupChat=%s" +
//            " WHERE" +
//            " groupChatId=%s" +
//            " AND" +
//            " userId=%s";
    int update(String groupChatId, UserDetailBean userDetailBean);

    //    String sql = "SELECT" +
//            " gcm.userId" +
//            ",gcm.nickname" +
//            ",gcm.headImg" +
//            ",gcm.headImgSmall" +
//            ",gcm.nicknameInGroupChat" +
//            ",f.remark" +
//            " FROM group_chat_member AS gcm" +
//            " LEFT OUTER JOIN friend AS f ON gcm.userId=f.id" +
//            " WHERE" +
//            " groupChatId=%s";
    List<UserDetailBean> selectByGroupChatId(String groupChatId);

    //    String sql = "SELECT" +
//            " gcm.userId" +
//            ",gcm.nickname" +
//            ",gcm.headImg" +
//            ",gcm.headImgSmall" +
//            ",gcm.nicknameInGroupChat" +
//            ",f.remark" +
//            " FROM group_chat_member AS gcm" +
//            " LEFT OUTER JOIN friend AS f ON gcm.userId=f.id" +
//            " WHERE" +
//            " groupChatId=%s" +
//            " AND" +
//            " userId=%s";
    UserDetailBean selectByGroupChatIdAndUserId(String groupChatId, String userId);

    //    String sql = "SELECT" +
//            " COUNT(userId)" +
//            " FROM group_chat_member" +
//            " WHERE" +
//            " groupChatId=%s" +
//            " AND" +
//            " userId=%s";
    boolean existsByGroupChatIdAndUserId(String groupChatId, String userId);
}
