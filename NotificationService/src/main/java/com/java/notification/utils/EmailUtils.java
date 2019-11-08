package com.java.notification.utils;

import com.java.notification.model.NotificationEventRequest;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils implements  NotificationUtils {
    @Override
    public boolean send(NotificationEventRequest notificationEventRequest) {
        System.out.println("Email Send is caliing ........");
        return notificationEventRequest.isWantSuccess();
    }
}
