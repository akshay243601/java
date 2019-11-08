package com.java.notification.utils;

import com.java.notification.model.NotificationEventRequest;
import org.springframework.stereotype.Component;

@Component
public class SmsUtil implements  NotificationUtils {
    @Override
    public boolean send(NotificationEventRequest notificationEventRequest) {
        System.out.println("Sms Send is calliing ........");
        return notificationEventRequest.isWantSuccess();
    }
}
