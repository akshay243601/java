package com.java.notification.utils;

import com.java.notification.model.NotificationEventRequest;
import org.springframework.stereotype.Component;

@Component
public class PushUtil implements  NotificationUtils {
    @Override
    public boolean send(NotificationEventRequest notificationEventRequest) {
        System.out.println("Push Send is calliing ........");
        return notificationEventRequest.isWantSuccess();
    }
}
