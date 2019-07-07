package com.ycjh.common.config;

import com.ycjh.common.Servletfilter.ResponseAPIFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
    public class ResponseAPIFilterConfig
    {
        @Bean
        public FilterRegistrationBean getFilterRegistrationBean()
        {
            FilterRegistrationBean registrationBean = new FilterRegistrationBean(new ResponseAPIFilter());
            return registrationBean;
        }
    }