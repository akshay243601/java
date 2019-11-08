package com.java.notification.service;

import com.java.notification.dao.SubscriptionDetailDao;
import com.java.notification.model.Response;
import com.java.notification.model.SubscriptionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionDetailService {

    @Autowired
    SubscriptionDetailDao subscriptionDetailDao;

    public Response getSubscriptions() {
        Response response = new Response();
        try {
            response.setData(subscriptionDetailDao.findAll());
            response.setSuccess(true);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
