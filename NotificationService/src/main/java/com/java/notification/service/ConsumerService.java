package com.java.notification.service;


import com.java.notification.dao.ClientSubscriptionDao;
import com.java.notification.dao.FailedNotificationLogDao;
import com.java.notification.dao.NotificationLogDao;
import com.java.notification.model.*;
import com.java.notification.utils.EmailUtils;
import com.java.notification.utils.NotificationUtils;
import com.java.notification.utils.SmsUtil;
import com.java.notification.utils.Utility;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ConsumerService {

    static ExecutorService executorService;

    @Autowired
    EmailUtils emailUtils;

    @Autowired
    SmsUtil smsUtil;

    @Autowired
    NotificationLogDao notificationLogDao;

    @Autowired
    FailedNotificationLogDao failedNotificationLogDao;

    @Autowired
    RedisCacheService redisCacheService;

    @Autowired
    SubscriptionValidityCheckService subscriptionValidityCheckService;

    @Autowired
    ClientSubscriptionDao clientSubscriptionDao;

    @RabbitListener(queues = "${notification.rabbit.queue.name}")
    public void recievedMessage(NotificationEventRequest notificationEventRequest) {
        System.out.println("Recieved Message From RabbitMQ: " + notificationEventRequest);
        executorService.submit(new Runnable() {
            public void run() {
                processNotification(notificationEventRequest);
            }
        });
    }

    static {
        executorService = Executors.newFixedThreadPool(5);
    }

    public boolean processNotification(NotificationEventRequest notificationEventRequest) {
        boolean response = true;
        if(null != notificationEventRequest) {
            NotificationUtils notificationUtils =  Utility.getNotificationUtils(notificationEventRequest.getNotificationType());
            try {
                response = notificationUtils.send(notificationEventRequest);
            } catch (Exception e) {
                response = false;
            }
            if(!response){
                failedNotificationLogDao.save(prepareFailedNotificationLogs(notificationEventRequest));
            } else {
                notificationLogDao.save(prepareNotificationLogs(notificationEventRequest, response));
                ClientSubscriptions clientSubscriptions = redisCacheService.getClientSubscription(notificationEventRequest.getClientId());
                if(clientSubscriptions == null) {
                    clientSubscriptions = subscriptionValidityCheckService.getClientSubscription(notificationEventRequest.getClientId());
                }
                if(clientSubscriptions != null) {
                    NotificationType notificationType = notificationEventRequest.getNotificationType();
                    if(clientSubscriptions.isSmsEnable() && notificationType == NotificationType.SMS) {
                        clientSubscriptions.setRemainingSms(clientSubscriptions.getRemainingSms() - 1);
                    } else if(clientSubscriptions.isMailEnable() && notificationType == NotificationType.MAIL) {
                        clientSubscriptions.setRemainingMail(clientSubscriptions.getRemainingMail() - 1);
                    } else if(clientSubscriptions.isPushEnable() && notificationType == NotificationType.PUSH) {
                        clientSubscriptions.setRemainingPush(clientSubscriptions.getRemainingPush() - 1);
                    }
                    clientSubscriptionDao.save(clientSubscriptions);
                }
            }
        }
        return response;
    }

    private NotificationLogs prepareNotificationLogs(NotificationEventRequest notificationEventRequest, boolean isSuccess) {
        NotificationLogs notificationLogs = new NotificationLogs();
        notificationLogs.setClientId(notificationEventRequest.getClientId());
        notificationLogs.setNotificationJson(Utility.objectToJson(notificationEventRequest));
        notificationLogs.setNotificationType(notificationEventRequest.getNotificationType().getType());
        notificationLogs.setCreatedDate(new Date());
        notificationLogs.setModifiedDate(new Date());
        notificationLogs.setStatus( isSuccess ? "SUCCESS" : "FAILED");
        return notificationLogs;
    }

    private FailedNotificationLogs prepareFailedNotificationLogs(NotificationEventRequest notificationEventRequest) {
        FailedNotificationLogs failedNotificationLogs = new FailedNotificationLogs();
        failedNotificationLogs.setClientId(notificationEventRequest.getClientId());
        failedNotificationLogs.setNotificationJson(Utility.objectToJson(notificationEventRequest));
        failedNotificationLogs.setNotificationType(notificationEventRequest.getNotificationType().getType());
        failedNotificationLogs.setStatus( "FAILED");
        failedNotificationLogs.setCreatedDate(new Date());
        failedNotificationLogs.setModifiedDate(new Date());
        failedNotificationLogs.setFailureCount(notificationEventRequest.getFailureCount() + 1);
        return failedNotificationLogs;
    }
}
