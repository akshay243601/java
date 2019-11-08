package com.java.notification.service;

import com.java.notification.model.NotificationEventRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ProducerService {


    @Value("${notification.rabbit.queue.name}")
    private String queueName;

    @Value("${notification.rabbit.queue.exchange}")
    private String exchange;

    @Value("${notification.rabbit.queue.routingKey}")
    private String routingkey;


    static ExecutorService executorService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private SubscriptionValidityCheckService subscriptionValidityCheckService;


    public String produce(NotificationEventRequest notificationEventRequest) {
        System.out.println("Sending message...");
        String response;
        try{
            if(subscriptionValidityCheckService.isSubscriptionExpire(notificationEventRequest)) {
                return "Your Subscription is not active for " + notificationEventRequest.getNotificationType().getType();
            }
            executorService.submit(new Runnable() {
                public void run() {
                    rabbitTemplate.convertAndSend(exchange, routingkey, notificationEventRequest);
                }
            });
              response = "NOTIFICATION IS IN PROCESS...";
        } catch(Exception e)
        {
            response = "Something went wrong.";
        }
        System.out.println("Sending message...");
        return response;
    }

    static {
        executorService = Executors.newFixedThreadPool(5);
    }

}
