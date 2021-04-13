package com.akshay.rateLimit;


public class ApiRateConfig {
    private String clientId;
    private int timesOfHit;
    private String ipAddress;
    private String userToken;
    private String url;
    private Integer MAX_HITS=100;



    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getTimesOfHit() {
        return timesOfHit;
    }

    public void setTimesOfHit(int timesOfHit) {
        this.timesOfHit = timesOfHit;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMAX_HITS() {
        return MAX_HITS;
    }

    public void setMAX_HITS(Integer MAX_HITS) {
        this.MAX_HITS = MAX_HITS;
    }
}
