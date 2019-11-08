package com.java.notification.service;

import com.java.notification.dao.ClientDao;
import com.java.notification.dao.ClientSubscriptionDao;
import com.java.notification.dao.SubscriptionDetailDao;
import com.java.notification.model.Client;
import com.java.notification.model.ClientSubscriptions;
import com.java.notification.model.Response;
import com.java.notification.model.SubscriptionDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    ClientDao clientDao;

    @Autowired
    ClientSubscriptionDao clientSubscriptionDao;

    @Autowired
    SubscriptionDetailDao subscriptionDetailDao;

    @Autowired
    RedisCacheService redisCacheService;

    public Response create(Client client) {
        logger.info("Client Create start " + client.toString());

        Response response = new Response();
        try {
            response.setSuccess(true);
            client.setToken(UUID.randomUUID().toString());
            response.setData(clientDao.save(client));
        } catch (Exception e) {
            response.setMessage(e.getMessage());
        }
        logger.info("Client Create response : " + response.toString());
        return response;
    }

    public Response buySubscription(ClientSubscriptions clientSubscriptions) {
        logger.info("Buy Subscription is calling .... " + clientSubscriptions);
        Response response = new Response();
        try {
            SubscriptionDetail subscriptionDetail = subscriptionDetailDao.findById(clientSubscriptions.getSubscriptionId()).orElse(null);
            ClientSubscriptions clientSubscriptionsDB = clientSubscriptionDao.findByClientId(clientSubscriptions.getClientId());

            if(subscriptionDetail != null) {
                if(null != clientSubscriptionsDB) {
                    clientSubscriptions.setId(clientSubscriptionsDB.getId());
                }
                if(subscriptionDetail.getSubscriptionType().equalsIgnoreCase("Silver")) {
                    clientSubscriptions.setMailEnable(true);
                    clientSubscriptions.setMaxMailCountPerDay(subscriptionDetail.getEmailCount());
                    clientSubscriptions.setRemainingMail(subscriptionDetail.getEmailCount());
                } else if(subscriptionDetail.getSubscriptionType().equalsIgnoreCase("Gold")) {
                    clientSubscriptions.setMailEnable(true);
                    clientSubscriptions.setSmsEnable(true);
                    clientSubscriptions.setMaxMailCountPerDay(subscriptionDetail.getEmailCount());
                    clientSubscriptions.setMaxSmsCountPerDay(subscriptionDetail.getSmsCount());
                    clientSubscriptions.setRemainingMail(subscriptionDetail.getEmailCount());
                    clientSubscriptions.setRemainingSms(subscriptionDetail.getSmsCount());
                } else if(subscriptionDetail.getSubscriptionType().equalsIgnoreCase("Platinum")) {
                    clientSubscriptions.setMailEnable(true);
                    clientSubscriptions.setSmsEnable(true);
                    clientSubscriptions.setPushEnable(true);
                    clientSubscriptions.setMaxMailCountPerDay(subscriptionDetail.getEmailCount());
                    clientSubscriptions.setMaxSmsCountPerDay(subscriptionDetail.getSmsCount());
                    clientSubscriptions.setMaxPushCountPerDay(subscriptionDetail.getPushCount());
                    clientSubscriptions.setRemainingPush(subscriptionDetail.getPushCount());
                    clientSubscriptions.setRemainingMail(subscriptionDetail.getEmailCount());
                    clientSubscriptions.setRemainingSms(subscriptionDetail.getSmsCount());
                }
                response.setData(clientSubscriptionDao.save(clientSubscriptions));
                redisCacheService.putClientSubscription(clientSubscriptions.getClientId(), clientSubscriptions);
                response.setSuccess(true);
            } else {
                response.setMessage("Subscription details not found.");
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        logger.info("Buy Subscription response .... " + response);
        return response;
    }

    public Response getSubscription(String clientId) {
        Response response = new Response();
        try {
            response.setData(clientSubscriptionDao.findByClientId(clientId));
            response.setSuccess(true);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
