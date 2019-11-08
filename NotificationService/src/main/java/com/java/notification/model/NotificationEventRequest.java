package com.java.notification.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class NotificationEventRequest {
    private NotificationType notificationType;
    private EmailInfo emailInfo;
    private SmsInfo smsInfo;
    private String clientId;
    private int failureCount;

    //just to test the success and failed API.
    private boolean wantSuccess;
}
