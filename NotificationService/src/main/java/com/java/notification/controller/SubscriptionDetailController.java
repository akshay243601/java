package com.java.notification.controller;

import com.java.notification.model.Response;
import com.java.notification.service.SubscriptionDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/subscription")
public class SubscriptionDetailController {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionDetailController.class);

    @Autowired
    SubscriptionDetailService subscriptionDetailService;

    @GetMapping("/details")
    public Response getSubscriptions()
    {
        logger.info("Get Subscriptions is calling..");
        return subscriptionDetailService.getSubscriptions();
    }
}
