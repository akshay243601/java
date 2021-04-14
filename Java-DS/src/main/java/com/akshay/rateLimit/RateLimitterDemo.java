package com.akshay.rateLimit;

public class RateLimitterDemo {
    public static void main(String[] args) {

        ApiRateConfig apiRateConfig1 = new ApiRateConfig("Client1", 100);
        ApiRateConfig apiRateConfig2 = new ApiRateConfig("Client2", 200);
        ApiRateConfig apiRateConfig3 = new ApiRateConfig("Client3", 300);
        ApiRateConfig apiRateConfig4 = new ApiRateConfig("Client4", 400);
        ApiRateConfig apiRateConfig5 = new ApiRateConfig("Client5", 500);




    }
}
