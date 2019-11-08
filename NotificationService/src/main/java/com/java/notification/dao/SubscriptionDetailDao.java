package com.java.notification.dao;

import com.java.notification.model.SubscriptionDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionDetailDao extends CrudRepository<SubscriptionDetail, Integer> {
}