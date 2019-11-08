package com.java.notification.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.notification.model.NotificationEventRequest;
import com.java.notification.model.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;

public class Utility {

    public static NotificationUtils getNotificationUtils(NotificationType notificationType) {
        NotificationUtils notificationUtils = null;
        if(notificationType.getType().equalsIgnoreCase(NotificationType.MAIL.getType())) {
            notificationUtils = new EmailUtils();
        } else if(notificationType.getType().equalsIgnoreCase(NotificationType.SMS.getType())) {
            notificationUtils = new SmsUtil();
        } else if(notificationType.getType().equalsIgnoreCase(NotificationType.PUSH.getType())) {
            notificationUtils = new PushUtil();
        } else if(notificationType.getType().equalsIgnoreCase(NotificationType.MAIL.getType())) {

        }
        return  notificationUtils;
    }

    public static String objectToJson(NotificationEventRequest notificationEventRequest) {
        String json = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(notificationEventRequest);
        } catch (Exception e) {
            //log
        }
        return json;
    }

    public static NotificationEventRequest jsonToObject(String json) {
        NotificationEventRequest notificationEventRequest = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            notificationEventRequest = objectMapper.readValue(json ,NotificationEventRequest.class);
        } catch (Exception e) {

        }
        return notificationEventRequest;
    }

}
