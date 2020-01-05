package com.qinshou.qinshoubox.im.cache;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/4 16:32
 * Description:缓存策略
 */
public interface ICache<K, V> {
    void put(K key, V value);

    V get(K key);
}
