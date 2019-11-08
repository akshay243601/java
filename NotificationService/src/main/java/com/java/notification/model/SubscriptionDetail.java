package com.java.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SUBSCRIPTION_DETAILS")
public class SubscriptionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String subscriptionType;
    private String subscriptionPrice;
    private Long emailCount;
    private Long smsCount;
    private Long pushCount;
}
