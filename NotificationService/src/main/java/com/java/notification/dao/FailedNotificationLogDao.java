package com.java.notification.dao;

import com.java.notification.model.FailedNotificationLogs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface FailedNotificationLogDao extends CrudRepository<FailedNotificationLogs, Integer> {
    Iterable<FailedNotificationLogs> findAllByClientId(String clientId);
}
