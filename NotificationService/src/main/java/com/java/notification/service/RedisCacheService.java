package com.java.notification.service;

import com.java.notification.model.ClientSubscriptions;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    @Cacheable(value = "Client_Subcriptions", key = "#clientId")
    public ClientSubscriptions getClientSubscription(String clientId) {
        return null;
    }

    @CachePut(value = "Client_Subcriptions", key = "#clientId")
    public void putClientSubscription(String clientId, ClientSubscriptions clientSubscriptions) {
    }

}
