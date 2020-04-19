package com.jeejio.dbmodule.tmp;

import com.jeejio.dbmodule.annotation.Delete;
import com.jeejio.dbmodule.annotation.Insert;
import com.jeejio.dbmodule.annotation.ObjParam;
import com.jeejio.dbmodule.annotation.Param;
import com.jeejio.dbmodule.annotation.Select;
import com.jeejio.dbmodule.annotation.Update;

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
    boolean existsById(@Param("id") ID id);
}
