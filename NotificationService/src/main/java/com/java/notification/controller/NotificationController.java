package com.java.notification.controller;

import com.java.notification.model.NotificationEventRequest;
import com.java.notification.model.Response;
import com.java.notification.service.FailedNotificationService;
import com.java.notification.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/notification")
public class NotificationController {
    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    NotificationService notificationService;

    @Autowired
    FailedNotificationService failedNotificationService;

    @PostMapping("/notify")
    public String notify(@RequestBody NotificationEventRequest notificationEventRequest)
    {
        logger.info("notify is calling. Request : " + notificationEventRequest);
        return  notificationService.notify(notificationEventRequest);
    }

    @GetMapping("/logs/{clientId}")
    public Response getNotificationLogs(@PathVariable("clientId") String clientId)
    {
        logger.info("notify logs is calling. Request : " + clientId);
        return  notificationService.getNotificationLogs(clientId);
    }

    @GetMapping("/failedLogs/{clientId}")
    public Response getFailedNotificationLogs(@PathVariable("clientId")  String clientId)
    {
        logger.info("notify failed logs is calling. Request : " + clientId);
        return  failedNotificationService.getFailedNotificationLogs(clientId);
    }


}


