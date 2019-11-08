package com.java.notification.filter;

import io.jsonwebtoken.Jwts;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class JwtTokenFilter implements Filter {

    String SECRET_KEY = "ahdjuwyuew123456789mbmnbcndc";
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("Request URI is: " + req.getRequestURI());
        String token = req.getHeader("JWT-TOKEN");
        if(((HttpServletRequest) request).getRequestURI().contains("/notify")) {
            //verifyJwt(token);
        }
        chain.doFilter(request, response);
        System.out.println("Response Status Code is: " + res.getStatus());
    }

    public void verifyJwt(String jwtToken) {
        Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJwt(jwtToken);
    }
}