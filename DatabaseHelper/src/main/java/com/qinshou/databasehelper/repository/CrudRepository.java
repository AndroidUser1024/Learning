package com.qinshou.databasehelper.repository;

import java.util.Optional;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/29 19:05
 * Description:
 */
public interface CrudRepository<T, ID> extends Repository<T, ID> {
    T save(T t);

    Iterable<T> saveAll(Iterable<T> iterable);

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<ID> iterable);

    long count();

    void deleteById(ID id);

    void delete(T t);

    void deleteAll(Iterable<T> iterable);

    void deleteAll();
}
