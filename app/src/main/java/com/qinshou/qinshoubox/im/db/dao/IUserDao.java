package com.qinshou.qinshoubox.im.db.dao;

import com.qinshou.qinshoubox.im.bean.UserDetailBean;

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

    //    String sql = "INSERT INTO user(" +
//            " id" +
//            " ,username" +
//            " ,nickname" +
//            " ,headImg" +
//            " ,headImgSmall" +
//            " ,phoneNumber" +
//            " ,email" +
//            " ,signature" +
//            " ,gender" +
//            ")" +
//            " VALUES" +
//            " (%s,%s,%s,%s,%s,%s,%s,%s,%s)";
    int insert(UserDetailBean userDetailBean);

    //    String sql = "DELETE FROM user" +
//            " WHERE" +
//            " id=%s";
    int delete(String id);

    //    String sql = "UPDATE user SET" +
//            " username=%s" +
//            " ,nickname=%s" +
//            " ,headImg=%s" +
//            " ,headImgSmall=%s" +
//            " ,phoneNumber=%s" +
//            " ,email=%s" +
//            " ,signature=%s" +
//            " ,gender=%s" +
//            " WHERE" +
//            " id=%s";
    int update(UserDetailBean userDetailBean);

    //    String sql = "SELECT" +
//            " u.id" +
//            " ,u.username" +
//            " ,u.nickname" +
//            " ,u.headImg" +
//            " ,u.headImgSmall" +
//            " ,u.phoneNumber" +
//            " ,u.email" +
//            " ,u.signature" +
//            " ,u.gender" +
//            " FROM user AS u" +
//            " WHERE" +
//            " u.id=%s";
    UserDetailBean selectById(String id);

    // existsById
    // SELECT COUNT(id) AS count FROM friend WHERE id=#{id};
    boolean existsById(String id);
}
