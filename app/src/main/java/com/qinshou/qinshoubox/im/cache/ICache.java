package com.qinshou.qinshoubox.im.cache;

import java.util.Collection;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/4 16:32
 * Description:缓存策略
 */
public interface ICache<K, V> {
    void put(K key, V value);

    V get(K key);

    V remove(K key);

    Collection<V> getValues();
}
