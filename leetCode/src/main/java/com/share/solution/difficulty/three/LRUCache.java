package com.share.solution.difficulty.three;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 手撕 LRU 借助 Linked Hash Map
 * TimeoutInfoHolder
 *
 * @author Lgq create on 2020/9/6
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = -7502098007030502891L;
    private final int cacheSize;


    @Deprecated
    public LRUCache(int initialCapacity, int cacheSize) {
        super((int) (Math.ceil(cacheSize / 0.75) + 1), 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //return super.removeEldestEntry(eldest);
        return size() > cacheSize;
    }


    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<String, String>(10);

    }
}
