package com.qinshou.qinshoubox.im.db;

import com.jeejio.dbmodule.annotation.Delete;
import com.jeejio.dbmodule.annotation.Param;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/17 15:44
 * Description:friend 表 Dao 层
 */
public interface IFriendDao {
    @Delete("DELETE FROM friend" +
            " WHERE" +
            " id=#{id}")
    void deleteById(@Param("id") String id);
}
