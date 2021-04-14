package com.akshay.rateLimit;

import java.util.Arrays;
import java.util.List;

public class RateLimitterDemo {
    public static void main(String[] args) throws Exception {

        ApiRateConfig apiRateConfig1 = new ApiRateConfig("Client1", 100);
        ApiRateConfig apiRateConfig2 = new ApiRateConfig("Client2", 200);
        ApiRateConfig apiRateConfig3 = new ApiRateConfig("Client3", 300);
        ApiRateConfig apiRateConfig4 = new ApiRateConfig("Client4", 400);
        ApiRateConfig apiRateConfig5 = new ApiRateConfig("Client5", 500);
        ApiRateConfig apiRateConfig6 = new ApiRateConfig("Client6", 5000);

        List<ApiRateConfig> list = Arrays.asList(apiRateConfig1, apiRateConfig2, apiRateConfig3, apiRateConfig4, apiRateConfig5, apiRateConfig6);
        RateLimitterProcessor rateLimitterProcessor = new RateLimitterProcessor();
        Long currTime = 200l;
        for (ApiRateConfig apiRateConfig : list) {
            System.out.println(rateLimitterProcessor.allowRequest(apiRateConfig, currTime));
            currTime = currTime + 100;
        }

        for (ApiRateConfig apiRateConfig : list) {
            System.out.println(rateLimitterProcessor.allowRequest(apiRateConfig, currTime));
            currTime = currTime + 100;
        }

    }
}
