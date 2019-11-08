package com.java.notification.controller;

import com.java.notification.model.Client;
import com.java.notification.model.ClientSubscriptions;
import com.java.notification.model.Response;
import com.java.notification.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientService clientService;

    @PutMapping("/create")
    public Response create(@RequestBody Client client) {
        logger.info("Create is calling...");
        return clientService.create(client);
    }

    @PutMapping("/buySubscription")
    public Response buySubscription(@RequestBody ClientSubscriptions clientSubscriptions) {
        logger.info("buySubscription is calling...");
        return clientService.buySubscription(clientSubscriptions);
    }

    @GetMapping("/subscription/detail/{clientId}")
    public Response getClientSubscription(@PathVariable("clientId") String clientId) {
        return clientService.getSubscription(clientId);
    }
}
