package com.qinshou.qinshoubox.im.db;

import com.jeejio.dbmodule.annotation.Insert;
import com.jeejio.dbmodule.annotation.ObjParam;
import com.jeejio.dbmodule.annotation.Param;
import com.jeejio.dbmodule.tmp.IBaseDao;
import com.qinshou.qinshoubox.im.bean.UserBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/17 9:08
 * Description:user 表的 Dao
 */
public interface IUserDao extends IBaseDao<UserBean,String> {

}
