package com.akshay.customLRU;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/
public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>(4);
        lruCache.put("1", "A1");
        lruCache.put("2", "A2");
        lruCache.put("3", "A3");

        lruCache.print();

        lruCache.put("4", "A4");
        lruCache.print();
        lruCache.put("5", "A5");
        lruCache.print();

        lruCache.put("3", "A33");
        lruCache.print();

        lruCache.get("2");
        lruCache.print();

    }
}
