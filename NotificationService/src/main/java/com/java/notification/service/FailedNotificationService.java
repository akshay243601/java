package com.java.notification.service;

import com.java.notification.dao.FailedNotificationLogDao;
import com.java.notification.model.FailedNotificationLogs;
import com.java.notification.model.NotificationEventRequest;
import com.java.notification.model.Response;
import com.java.notification.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FailedNotificationService {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    FailedNotificationLogDao failedNotificationLogDao;

    public Response getFailedNotificationLogs(String clientId) {
        Response response = new Response();
        try
        {
            Iterable<FailedNotificationLogs> failedNotificationLogs = failedNotificationLogDao.findAllByClientId(clientId);
            List<FailedNotificationLogs> list = new ArrayList<>();
            failedNotificationLogs.forEach(x -> list.add(x));
            response.setData(list);
            response.setSuccess(true);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
        }
        return response;
    }

    void proessFailedEvent(FailedNotificationLogs failedNotificationLog){
        if(failedNotificationLog.getFailureCount() > 3) {
            return;
        }
        consumerService.processNotification(prepareNotificationEvent(failedNotificationLog));
        failedNotificationLogDao.delete(failedNotificationLog);
    }

    private NotificationEventRequest prepareNotificationEvent(FailedNotificationLogs failedNotificationLog) {
        NotificationEventRequest notificationEventRequest = Utility.jsonToObject(failedNotificationLog.getNotificationJson());
        notificationEventRequest.setFailureCount(failedNotificationLog.getFailureCount());
        return notificationEventRequest;
    }

    public void processFailedEvents(){
        Iterable<FailedNotificationLogs> failedLogs =  failedNotificationLogDao.findAll();
        for (FailedNotificationLogs failedNotificationLog: failedLogs) {
            proessFailedEvent(failedNotificationLog);
        }
    }

}
