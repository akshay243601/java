package com.java.notification;

import java.util.Arrays;

import com.java.notification.dao.SubscriptionDetailDao;
import com.java.notification.model.EmailInfo;
import com.java.notification.model.NotificationEventRequest;
import com.java.notification.model.NotificationType;
import com.java.notification.model.SubscriptionDetail;
import com.java.notification.service.ProducerService;
import com.java.notification.utils.RedisUtility;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sun.util.resources.ga.LocaleNames_ga;

@Component
public class Runner implements CommandLineRunner {


    @Autowired
    private SubscriptionDetailDao subscriptionDetailDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...Start");
        insertSubscriptions();
        System.out.println("Sending message...End");
    }


    private void insertSubscriptions() {
        SubscriptionDetail silver = new SubscriptionDetail();
        silver.setId(1);
        silver.setSubscriptionType("Silver");
        silver.setEmailCount(1000000L);
        silver.setSubscriptionPrice("49$");

        SubscriptionDetail gold = new SubscriptionDetail();
        gold.setId(2);
        gold.setSubscriptionType("Gold");
        gold.setEmailCount(10000000L);
        gold.setSmsCount(10000000L);
        gold.setSubscriptionPrice("99$");

        SubscriptionDetail platinum = new SubscriptionDetail();
        platinum.setId(3);
        platinum.setSubscriptionType("Platinum");
        platinum.setEmailCount(Long.MAX_VALUE);
        platinum.setSmsCount(Long.MAX_VALUE);
        platinum.setPushCount(Long.MAX_VALUE);
        platinum.setSubscriptionPrice("500$");
        subscriptionDetailDao.saveAll(Arrays.asList(silver, gold, platinum));
   }

}