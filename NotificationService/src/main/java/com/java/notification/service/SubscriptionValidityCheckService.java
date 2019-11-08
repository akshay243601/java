package com.java.notification.service;

import com.java.notification.dao.ClientSubscriptionDao;
import com.java.notification.model.ClientSubscriptions;
import com.java.notification.model.NotificationEventRequest;
import com.java.notification.model.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionValidityCheckService {

    @Autowired
    ClientSubscriptionDao clientSubscriptionDao;

    @Autowired
    RedisCacheService redisCacheService;


    public ClientSubscriptions getClientSubscription(String clientId) {
        //Put Logic for Cache
        ClientSubscriptions clientSubscriptions = clientSubscriptionDao.findByClientId(clientId);
        if(clientSubscriptions == null) {
            return null;
        }
        checkIsExpire(clientSubscriptions);
        redisCacheService.putClientSubscription(clientSubscriptions.getClientId(), clientSubscriptions);
        return clientSubscriptions;
    }

    private void checkIsExpire(ClientSubscriptions clientSubscriptions) {
        if(null == clientSubscriptions) {
            return;
        }
        if(clientSubscriptions.isMailEnable() && clientSubscriptions.getRemainingMail() <= 0) {
            clientSubscriptions.setMailExpire(true);
        }
        if(clientSubscriptions.isSmsEnable() &&clientSubscriptions.getRemainingSms() <= 0) {
            clientSubscriptions.setSmsExpire(true);
        }
        if(clientSubscriptions.isPushEnable() && clientSubscriptions.getRemainingPush() <= 0) {
            clientSubscriptions.setPushExpire(true);
        }
    }

    public boolean isSubscriptionExpire(NotificationEventRequest notificationEventRequest) {
        if(notificationEventRequest == null)
            return true;
        //Put Logic For Redis Cache
        ClientSubscriptions clientSubscription = redisCacheService.getClientSubscription(notificationEventRequest.getClientId());
        if(clientSubscription == null) {
            clientSubscription = getClientSubscription(notificationEventRequest.getClientId());
        }
        if(clientSubscription == null) {
            return true;
        }

        NotificationType notificationType = notificationEventRequest.getNotificationType();
        if(notificationType == NotificationType.MAIL) {
            return !clientSubscription.isMailEnable() || clientSubscription.isMailExpire();
        } else if(notificationType == NotificationType.SMS) {
            return !clientSubscription.isSmsEnable() || clientSubscription.isSmsExpire();
        } else if(notificationType == NotificationType.PUSH) {
            return !clientSubscription.isPushEnable() || clientSubscription.isPushExpire();
        }
        return false;
    }
}
