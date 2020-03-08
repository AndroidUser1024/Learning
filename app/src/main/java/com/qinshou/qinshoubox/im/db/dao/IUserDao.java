package com.qinshou.qinshoubox.im.db.dao;

import com.qinshou.qinshoubox.friend.bean.UserDetailBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/03/08 下午7:51
 * Description:用户 Dao
 */
public interface IUserDao extends IBaseDao<UserDetailBean> {
    // 创建表语句
    // "CREATE TABLE IF NOT EXISTS user(" +
    //            " id TEXT PRIMARY KEY" +
    //            " ,username TEXT" +
    //            " ,nickname TEXT" +
    //            " ,headImg TEXT" +
    //            " ,headImgSmall TEXT" +
    //            " ,phoneNumber TEXT" +
    //            " ,email TEXT" +
    //            " ,signature TEXT" +
    //            " ,gender INTEGER" +
    //            ")"
    // INSERT INTO user () VALUES ()
    int insert(UserDetailBean userDetailBean);

    int delete(String id);

    int update(UserDetailBean userDetailBean);

    UserDetailBean selectById(String id);
}
