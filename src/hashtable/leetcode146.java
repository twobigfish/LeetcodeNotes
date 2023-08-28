package hashtable;

import java.util.LinkedHashMap;

/**
 * @author: Dayuu
 * @description: 146. LRU 缓存
 */
//https://leetcode.cn/problems/lru-cache/solutions/12711/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/

class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 如果不存在，返回-1
        if (!cache.containsKey(key)) {
            return -1;
        }

        // 将key变为最近使用
        updateRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        // 1. 如果存在key
        if (cache.containsKey(key)) {
            //修改key对应的值
            cache.put(key, value);
            // 将key变为最近使用
            updateRecently(key);
            return;
        } else {// 2. 如果key不存在
            // 2.1 cache内存满了，先删除
            if (cache.size() == this.capacity) {
                // 删除队头最久未使用的key
                int oldkey = cache.keySet().iterator().next(); // 单独记一下
                cache.remove(oldkey);
            }
            // 2.2 cache未满，直接插入

            cache.put(key, value);
        }
    }

    // 更新为最近使用的元素
    // 靠近队头的是最近未使用的
    private void updateRecently(int key) {
        int val = cache.get(key);
        // 删除队头旧的key，在队尾重新插入
        cache.remove(key);
        cache.put(key, val);
    }
}


public class leetcode146 {
}
