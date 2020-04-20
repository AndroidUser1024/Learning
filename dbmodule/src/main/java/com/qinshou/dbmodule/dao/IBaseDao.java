package com.qinshou.dbmodule.dao;

import com.qinshou.dbmodule.annotation.Delete;
import com.qinshou.dbmodule.annotation.Insert;
import com.qinshou.dbmodule.annotation.ObjParam;
import com.qinshou.dbmodule.annotation.Param;
import com.qinshou.dbmodule.annotation.Select;
import com.qinshou.dbmodule.annotation.Update;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/18 18:40
 * Description:该接口定义了一些操作持久化类的基本方法
 */
public interface IBaseDao<T, ID> {
    @Insert("${insert}")
    T insert(@ObjParam() T t);

    @Delete("${deleteById}")
    int deleteById(@Param("id") ID id);

    @Update("${updateById}")
    T updateById(@ObjParam() T t);

    @Select("${selectById}")
    T selectById(@Param("id") ID id);

    @Select("${selectList}")
    List<T> selectList();

    @Select("${existsById}")
    int existsById(@Param("id") ID id);
}
