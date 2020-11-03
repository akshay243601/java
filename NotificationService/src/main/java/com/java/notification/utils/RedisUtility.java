package com.java.notification.utils;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisUtility {

    @Cacheable(value = "APILimiter", key = "#key")
    public int getRedisData(String key) {
        return 0;
    }

    @CachePut(value = "APILimiter", key = "#key")
    public int putRedisData(String key, int redisData) {
        return redisData;
    }
}
