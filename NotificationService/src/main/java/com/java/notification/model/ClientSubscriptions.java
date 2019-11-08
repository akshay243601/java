package com.java.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "CLIENT_SUBSCRIPTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CLIENT_SUBSCRIPTION")
public class ClientSubscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String clientId;
    private int subscriptionId;
    private boolean isSmsEnable;
    private boolean isMailEnable;
    private boolean isPushEnable;
    private Long maxMailCountPerDay;
    private Long maxSmsCountPerDay;
    private Long maxPushCountPerDay;
    private Long remainingMail;
    private Long remainingSms;
    private Long remainingPush;
    private boolean isMailExpire;
    private boolean isPushExpire;
    private boolean isSmsExpire;
}
