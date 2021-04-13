package com.akshay.rateLimit;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

public class RateLimitterProcessor {
    public static String APPENDER = "_";
    public static Long MAX_EXPIRY = 1000l; //ms
    Map<String, Queue<Long>> cache;

    public RateLimitterProcessor() {
        cache = new HashMap<>();
    }
    public synchronized boolean allowRequest(ApiRateConfig apiRateConfig, Long timeOfHit) throws Exception {
        String key = generateKey(apiRateConfig);
        if(cache.containsKey(key)) {
            Queue<Long> timings = cache.get(key);
            while(!timings.isEmpty() && timeOfHit - timings.peek() >= MAX_EXPIRY) {
                timings.poll();
            }
            if(timings.size() < apiRateConfig.getMAX_HITS()) {
                timings.add(timeOfHit);
                return true;
            } else  {
                throw new Exception("Too many request");
            }
        } else {
            Queue<Long> timings = new LinkedList<>();
            timings.add(timeOfHit);
            cache.put(key, timings);
            return true;
        }
    }


    private String generateKey(ApiRateConfig apiRateConfig) {
        return  append(apiRateConfig.getClientId(), apiRateConfig.getIpAddress(), apiRateConfig.getUserToken(), apiRateConfig.getUrl());
    }

    private String append(String... keys) {
        StringBuilder res = new StringBuilder();
        boolean isFirst = false;
        for (String key : keys) {
            if(key != null && !key.isEmpty()) {
                if(isFirst) {
                    res.append(key);
                    isFirst = true;
                } else {
                    res.append(APPENDER).append(key);
                }
            }
        }
        return res.toString();
    }


}
