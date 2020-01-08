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
    // ,toUserId TEXT,type INTEGER,lastMsgContentType INTEGER
    // ,lastMsgContent TEXT,lastMsgTimestamp INTEGER
    // ,lastMsgPid INTEGER,unreadCount INTEGER
    // );

    // 插入语句
    // INSERT INTO conversation
    // (toUserId,type,lastMsgContentType,lastMsgContent,lastMsgTimestamp
    // ,lastMsgPid,unreadCount)
    // VALUES
    // (#{toUserId},#{type},#{lastMsgContentType},#{lastMsgContent}
    // ,#{lastMsgTimestamp},#{lastMsgPid},#{unreadCount});
    ConversationBean insert(ConversationBean conversationBean);

    // 修改语句
    // UPDATE conversation SET
    // toUserId=#{toUserId},type=#{type},lastMsgContentType=#{lastMsgContentType}
    // ,lastMsgContent=#{lastMsgContent},lastMsgTimestamp=#{lastMsgTimestamp}
    // ,lastMsgPid={lastMsgPid},unreadCount=#{unreadCount}
    // WHERE id=#{id};
    void update(ConversationBean conversationBean);

    // 查询语句
    // SELECT
    // c.id,c.toUserId,c.type,c.lastMsgContentType,c.lastMsgContent
    // ,c.lastMsgTimestamp,c.lastMsgPid,c.unreadCount
    // ,f.doNotDisturb,f.blackList
    // FROM conversation AS c
    // LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001
    // LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001
    // WHERE f.id=#{id};

    // SELECT
    // c.id,c.toUserId,c.type,c.lastMsgContentType,c.lastMsgContent
    // ,c.lastMsgTimestamp,c.lastMsgPid,c.unreadCount
    // ,f.nickname,f.headImgSmall,f.remark,f.top,f.doNotDisturb
    // ,gc.nickname,gc.headImgSmall,gc.nicknameDefault,gc.top,gc.doNotDisturb
    // FROM conversation AS c
    // LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001
    // LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001
    // WHERE c.type=#{type} AND c.toUserId=#{toUserId};
    ConversationBean selectByTypeAndToUserId(int type, String toUserId);

    // 查询列表语句
    // SELECT
    // c.id,c.toUserId,c.type,c.lastMsgContentType,c.lastMsgContent
    // ,c.lastMsgTimestamp,c.lastMsgPid,c.unreadCount
    // ,f.nickname,f.headImgSmall,f.remark,f.top,f.doNotDisturb
    // ,gc.nickname,gc.headImgSmall,gc.nicknameDefault,gc.top,gc.doNotDisturb
    // FROM conversation AS c
    // LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001
    // LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001
    // ORDER BY c.lastMsgTimestamp DESC;
    List<ConversationBean> selectList();

    List<ConversationBean> selectListOrderByLastMsgTimeDesc();

    List<ConversationBean> selectListOrderByTopDescAndLastMsgTimeDesc();

    // SELECT SUM(unreadCount) AS totalUnreadCount FROM conversation;
    int getTotalUnreadCount();

    // UPDATE conversation SET unreadCount=0 WHERE id=#{id};
    int resetUnreadCount(int id);

    // 删除语句
    // DELETE FROM conversation WHERE id=#{id};
    int deleteById(int id);

    // UPDATE conversation SET unreadCount=-1 WHERE id=#{id};
    int setUnreadCount(int unreadCount, int id);

    // existsById
    // SELECT COUNT(id) FROM conversation WHERE id=#{id}
    boolean existsById(int id);

}
