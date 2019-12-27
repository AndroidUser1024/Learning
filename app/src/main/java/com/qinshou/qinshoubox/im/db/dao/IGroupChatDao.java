package com.qinshou.qinshoubox.im.db.dao;

import com.qinshou.qinshoubox.im.bean.GroupChatBean;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/04 22:23
 * Description:group_chat 表的 Dao
 */
public interface IGroupChatDao extends IBaseDao {
    // 创建表语句
    // CREATE TABLE IF NOT EXISTS group_chat(id TEXT PRIMARY KEY
    // ,ownerId TEXT,nickname TEXT,headImg TEXT
    // ,headImgSmall TEXT,nicknameDefault TEXT,nicknameInGroupChat TEXT
    // ,top INTEGER,doNotDisturb INTEGER,showGroupChatMemberNickname INTEGER
    // );

    // 插入语句
    // INSERT INTO group_chat
    // (id,ownerId,nickname,headImg,headImgSmall,nicknameDefault
    // ,nicknameInGroupChat,top,doNotDisturb,showGroupChatMemberNickname)
    // VALUES
    // (#{id},#{ownerId},#{nickname},#{headImg},#{headImgSmall}
    // ,#{nicknameDefault},#{nicknameInGroupChat},#{top},#{doNotDisturb}
    // ,#{showGroupChatMemberNickname});
    int insert(GroupChatBean groupChatBean);

    // 修改语句
    // UPDATE group_chat SET
    // ownerId=#{ownerId},nickname=#{nickname},headImg=#{headImg}
    // ,headImgSmall=#{headImgSmall},nicknameDefault=#{nicknameDefault}
    // ,nicknameInGroupChat=#{nicknameInGroupChat},top=#{top}
    // ,doNotDisturb=#{doNotDisturb},showGroupChatMemberNickname=#{showGroupChatMemberNickname}
    // WHERE id=#{id};
    int update(GroupChatBean groupChatBean);

    // 查询语句
    // SELECT
    // gc.id,gc.ownerId,gc.nickname,gc.headImg,gc.headImgSmall
    // ,gc.nicknameDefault,gc.nicknameInGroupChat
    // ,gc.top,gc.doNotDisturb,gc.showGroupChatMemberNickname
    // FROM group_chat AS gc
    // WHERE id=#{id};
    GroupChatBean selectById(String id);

    // existsById
    // SELECT COUNT(id) AS count FROM group_chat WHERE id=#{id};
    boolean existsById(String id);
}
