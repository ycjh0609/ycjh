package com.ycjh.common.config;


import com.ycjh.common.Interceptor.CommonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommonInterceptor())
                .addPathPatterns("/**/*")
                .excludePathPatterns("/test/**/");
                //.excludePathPatterns("/users/login/**/"); //exlcude login
    }
}
