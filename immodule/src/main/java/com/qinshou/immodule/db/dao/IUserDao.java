
package com.qinshou.immodule.db.dao;

import com.qinshou.immodule.bean.UserBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/2 11:21
 * Description:UserBean 的 Dao 层
 */
public interface IUserDao {
    int insertOrUpdate(UserBean userBean);

    UserBean getById(int id);

    UserBean getByUsername(String username);
}
