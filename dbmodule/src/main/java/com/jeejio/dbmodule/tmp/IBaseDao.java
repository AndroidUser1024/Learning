package com.jeejio.dbmodule.tmp;

import com.jeejio.dbmodule.annotation.Delete;
import com.jeejio.dbmodule.annotation.Insert;
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
    T insert(T t);

    @Delete("${deleteById}")
    int deleteById(ID id);

    @Update("${updateById}")
    T updateById(T t);

    @Select("${selectById}")
    T selectById(ID id);

    @Select("${selectList}")
    List<T> selectList();

    @Select("${existsById}")
    boolean existsById(ID id);
}
