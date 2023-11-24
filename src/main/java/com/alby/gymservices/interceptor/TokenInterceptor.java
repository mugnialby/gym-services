package com.alby.gymservices.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        long tokenExpiredAt = Long.parseLong(token.substring(token.lastIndexOf("_")));

        if (System.currentTimeMillis() > tokenExpiredAt) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return false;
        } else {
            return true;
        }
    }
}
