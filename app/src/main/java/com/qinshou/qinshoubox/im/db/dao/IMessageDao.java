package com.qinshou.qinshoubox.im.db.dao;

import com.qinshou.qinshoubox.im.bean.MessageBean;

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
}
