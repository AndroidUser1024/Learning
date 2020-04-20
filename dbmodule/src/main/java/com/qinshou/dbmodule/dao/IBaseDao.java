package com.qinshou.dbmodule.dao;

import com.qinshou.dbmodule.condition.QueryCondition;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/18 18:40
 * Description:该接口定义了一些操作持久化类的基本方法
 */
public interface IBaseDao<T> {
    T save(T t);

    T insert(T t);

    int deleteById(Object id);

    int delete(T t);

    int delete(QueryCondition... queryConditionArray);

    T update(T t);

    T update(T t, QueryCondition... queryConditionArray);

    T select(QueryCondition... queryConditionArray);

    T selectById(Object id);

    List<T> selectList();

    List<T> selectList(QueryCondition... queryConditionArray);

    boolean existsById(Object id);
}
