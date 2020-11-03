package com.java.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
@EnableCaching
public class Application {

    //Swager UI URL : http://127.0.0.1:8081/swagger-ui.html
    // DB userName : root, password : "" [blank]
    // No need to even create table It will automatically created. Just need to create database name "notification_service"
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @CacheEvict(allEntries = true, value = {"APILimiter"})
    @Scheduled(fixedDelay = 1 * 30 * 1000 ,  initialDelay = 500) //In every 30 sec It will delete the cache
    public void reportCacheEvict() {
        System.out.println("Flush Cache " + new Date());
    }

}