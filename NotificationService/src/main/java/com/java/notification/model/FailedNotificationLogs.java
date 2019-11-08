package com.java.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FAILED_NOTIFICATION_LOGS")
public class FailedNotificationLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String clientId;

    @Lob
    private String notificationJson;

    private String notificationType;

    private Date createdDate;

    private Date modifiedDate;

    private String status;

    private int failureCount;

}
