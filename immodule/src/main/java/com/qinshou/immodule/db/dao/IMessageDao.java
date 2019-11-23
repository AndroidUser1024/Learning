package com.qinshou.immodule.db.dao;


import com.qinshou.immodule.bean.MessageBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/2 11:21
 * Description:MessageBean 的 Dao 层
 */
public interface IMessageDao {
    int insertOrUpdate(boolean send, MessageBean messageBean);
}
