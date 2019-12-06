package com.qinshou.qinshoubox.im.db.dao;

import com.qinshou.qinshoubox.im.bean.ConversationBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/04 23:06
 * Description:conversation 表的 Dao
 */
public interface IConversationDao extends IBaseDao {
    // 创建表语句
    // CREATE TABLE IF NOT EXISTS conversation(id INTEGER PRIMARY KEY AUTOINCREMENT
    // ,toUserId TEXT,type INTEGER,lastMsgContent TEXT
    // ,lastMsgContentType INTEGER,lastMsgTimestamp INTEGER
    // ,unreadCount INTEGER
    // );

    // 插入语句
    // INSERT INTO conversation
    // (toUserId,type,lastMsgContent,lastMsgContentType,lastMsgTimestamp
    // ,unreadCount)
    // VALUES
    // (#{toUserId},#{type},#{lastMsgContent},#{lastMsgContentType}
    // ,#{lastMsgTimestamp},#{unreadCount});
    ConversationBean insert(ConversationBean conversationBean);

    // 修改语句
    // UPDATE conversation SET
    // toUserId=#{toUserId},type=#{type},lastMsgContent=#{lastMsgContent}
    // ,lastMsgContentType=#{lastMsgContentType},lastMsgTimestamp=#{lastMsgTimestamp}
    // ,unreadCount=#{unreadCount}
    // WHERE id=#{id};

    // 查询语句
    // SELECT
    // c.id,c.toUserId,c.type,c.lastMsgContent,c.lastMsgContentType
    // ,c.lastMsgTimestamp,c.unreadCount
    // ,f.doNotDisturb,f.blackList
    // FROM conversation AS c
    // LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001
    // LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001
    // WHERE f.id=#{id};

    // 查询列表语句
    // SELECT
    // c.id,c.toUserId,c.type,c.lastMsgContent,c.lastMsgContentType
    // ,c.lastMsgTimestamp,c.unreadCount
    // ,f.nickname,f.headImgSmall,f.remark,f.top,f.doNotDisturb
    // ,gc.nickname,gc.headImgSmall,gc.nicknameDefault,gc.top,gc.doNotDisturb
    // FROM conversation AS c
    // LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001
    // LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001
    // ORDER BY c.lastMsgTimestamp DESC;
    List<ConversationBean> selectList();

    // selectByToUserIdAndType
    // SELECT
    // c.id,c.toUserId,c.type,c.lastMsgContent,c.lastMsgContentType
    // ,c.lastMsgTimestamp,c.unreadCount
    // ,f.nickname,f.headImgSmall,f.remark,f.top,f.doNotDisturb
    // ,gc.nickname,gc.headImgSmall,gc.nicknameDefault,gc.top,gc.doNotDisturb
    // FROM conversation AS c
    // LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001
    // LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001
    // WHERE c.toUserId=#{toUserId} AND c.type=#{type};
    ConversationBean selectByToUserIdAndType(String toUserId, int type);
}
