package com.ycjh.common.config;

import com.ycjh.common.Interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TokenInterceptorConfig implements WebMvcConfigurer {

    // Interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.
                addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**/*")
                .excludePathPatterns("/users/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/resource/**")
                .excludePathPatterns("/jwt/**")
                .excludePathPatterns("/error/**")
                .excludePathPatterns("/error")

                ;
    }
}
