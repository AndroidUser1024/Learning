
package com.qinshou.immodule.db.dao;


import com.qinshou.immodule.bean.GroupChatBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/2 11:21
 * Description:GroupChatBean 的 Dao 层
 */
public interface IGroupChatDao {
    int insertOrUpdate(GroupChatBean groupChatBean);

    GroupChatBean getById(int id);
}
