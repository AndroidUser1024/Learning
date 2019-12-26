package com.qinshou.qinshoubox.im.db.dao;

import com.qinshou.qinshoubox.im.bean.MessageBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/04 22:58
 * Description:message 表的 Dao
 */
public interface IMessageDao extends IBaseDao {
    // 创建表语句
    // CREATE TABLE IF NOT EXISTS message(pid INTEGER PRIMARY KEY AUTOINCREMENT
    // ,id TEXT,fromUserId TEXT,toUserId TEXT,type INTEGER
    // ,contentType INTEGER,content TEXT,sendTimestamp INTEGER
    // ,receiveTimestamp INTEGER,status INTEGER,extend TEXT
    // )

    // 插入语句
    // INSERT INTO message
    // (id,fromUserId,toUserId,type,contentType,content,sendTimestamp,receiveTimestamp,status,extend)
    // VALUES
    // (#{id},#{fromUserId},#{toUserId},#{type},#{contentType},#{content},#{sendTimestamp}
    // ,#{receiveTimestamp},#{status},#{extend})
    MessageBean insert(MessageBean messageBean);

    // 查询语句
    // 分页查询
    //    SELECT m.pid,
    //    m.id,
    //    m.fromUserId,
    //    m.toUserId,
    //    m.type,
    //    m.contentType,
    //    m.content,
    //    m.sendTimestamp,
    //    m.receiveTimestamp,
    //    m.status,
    //    m.extend
    //    FROM conversation_message_rel AS cmr
    //    LEFT OUTER JOIN
    //    message AS m ON m.pid = cmr.messagePid
    //    WHERE cmr.conversationId = #{conversationId}
    //    LIMIT #{page}*#{pageSize},(#{page}+1)*#{pageSize};
    List<MessageBean> selectList(int conversationId, int page, int pageSize);

    // 查询语句
    // SELECT m.pid,m.id,m.fromUserId,m.toUserId,m.type,m.contentType,m.content,m.sendTimestamp,m.receiveTimestamp
    // ,m.status,m.extend
    // FROM message AS m
    // WHERE m.pid=#{pid};
    MessageBean selectByPid(int pid);

    // 修改语句
    // UPDATE message SET id=#{id},fromUserId=#{fromUserId},toUserId=#{toUserId},type=#{type}
    // ,contentType=#{contentType},content=#{content},sendTimestamp=#{sendTimestamp}
    // ,receiveTimestamp=#{receiveTimestamp},status=#{status},extend=#{extend}
    // WHERE pid=#{pid};
    int update(MessageBean messageBean);
}
