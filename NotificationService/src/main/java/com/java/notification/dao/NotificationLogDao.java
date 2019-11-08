package com.java.notification.dao;

import com.java.notification.model.NotificationLogs;
import com.java.notification.model.Response;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface NotificationLogDao extends CrudRepository<NotificationLogs, Integer> {
    Iterable<NotificationLogs> findAllByClientId(String clientId);
}
