package com.alby.gymservices.config.webmvcconfigurer;

import com.alby.gymservices.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .excludePathPatterns("/api/v1/member/register")
                .excludePathPatterns("/api/v1/auth/**")
                .excludePathPatterns("/api/v1/token/**");
    }
}
