package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DesignATinyUrl {

    Map<String, String> tinyUrlMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyUrl = generateRandomString();
        tinyUrlMap.put(tinyUrl, longUrl);
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyUrlMap.get(shortUrl);
    }

    private String generateRandomString(){
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array);
    }

}
