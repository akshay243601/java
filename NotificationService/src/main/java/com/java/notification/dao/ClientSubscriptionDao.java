package com.java.notification.dao;

import com.java.notification.model.ClientSubscriptions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ClientSubscriptionDao extends CrudRepository<ClientSubscriptions, Integer> {
    ClientSubscriptions findByClientId(String clientId);
}
