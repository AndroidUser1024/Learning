package com.jeejio.dbmodule.tmp;

import com.jeejio.dbmodule.annotation.Insert;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/18 18:40
 * Description:该接口定义了一些操作持久化类的基本方法
 */
public interface IBaseDao<T, ID> {
    T insert(T t);

    int deleteById(ID id);

    T updateById(T t);

    T selectById(ID id);

    List<T> selectList();

    boolean existsById(ID id);
}
