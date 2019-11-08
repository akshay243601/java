package com.java.notification.service;

import com.java.notification.dao.NotificationLogDao;
import com.java.notification.model.NotificationEventRequest;
import com.java.notification.model.NotificationLogs;
import com.java.notification.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    ProducerService producerService;

    @Autowired
    NotificationLogDao notificationLogDao;

    public String notify(NotificationEventRequest notificationEventRequest) {
        return producerService.produce(notificationEventRequest);
    }

    public Response getNotificationLogs(String clientId) {
        Response response = new Response();
        try
        {
            Iterable<NotificationLogs> notificationLogs = notificationLogDao.findAllByClientId(clientId);
            List<NotificationLogs> list = new ArrayList<>();
            notificationLogs.forEach(x -> list.add(x));
            response.setData(list);
            response.setSuccess(true);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
