package com.java.notification.jobs;

import com.java.notification.service.FailedNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    FailedNotificationService failedNotificationService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void processFailedNotifications()
    {
        long currMiliSec = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time is : " + currMiliSec);
        failedNotificationService.processFailedEvents();
    }

}