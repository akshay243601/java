package com.java.notification.filter;

import com.java.notification.utils.RedisUtility;
import lombok.SneakyThrows;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class CustomRateLimiter implements Filter {

    @Autowired
    RedisUtility redisUtility;

    private int MAX_API_LIMIT_PER_MINUTE = 5;

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String url = null;
        if(servletRequest instanceof RequestFacade) {
            url = ((RequestFacade)servletRequest).getServletPath();
        } else if(servletRequest instanceof HttpRequest) {
            url = ((HttpRequest)servletRequest).getURI().getPath();
        }
        System.out.println(url);

        int apiCalledCount = redisUtility.getRedisData(url);
        System.out.println(apiCalledCount);

        if(apiCalledCount > MAX_API_LIMIT_PER_MINUTE) {
            throw new Exception("limit exceeded");
        }

        // All the cache will be expiry in 30 sec Check code in Application.java.
        // We have schedule a job which will delete the specific cache in every 30 secs.
        redisUtility.putRedisData(url, apiCalledCount + 1);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
