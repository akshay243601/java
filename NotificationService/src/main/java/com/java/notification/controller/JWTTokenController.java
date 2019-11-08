package com.java.notification.controller;

import com.java.notification.model.Response;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/jwt")
public class JWTTokenController {
    String SECRET_KEY = "ahdjuwyuew123456789mbmnbcndc";

    @GetMapping("/get/{clientId}")
    public Response getToken(@PathVariable("clientId") String clientId) {
        Response response = new Response();
        response.setSuccess(true);
        Map<String, String> jwtClaims = new HashMap<>();
        jwtClaims.put("clientId", clientId);
        jwtClaims.put("ts", String.valueOf(System.currentTimeMillis()));
        jwtClaims.put("iss", "ts");
        response.setData(Jwts.builder().setPayload(jwtClaims.toString()).signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact());
        return response;
    }
}
