
package com.qinshou.qinshoubox.im.db.dao;

import com.qinshou.qinshoubox.im.bean.FriendBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/2 11:21
 * Description:UserBean 的 Dao 层
 */
public interface IFriendDao {
    int insertOrUpdate(FriendBean friendBean);

    FriendBean getById(int id);

    FriendBean getByUsername(String username);
}
