package com.ycjh.common.config;


import com.ycjh.common.Interceptor.CommonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    // Interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.
                addInterceptor(new CommonInterceptor())
                .addPathPatterns("/**/*")
                .excludePathPatterns("/resource/**");
                //.excludePathPatterns("/users/login/**/"); //exlcude login
    }
}
