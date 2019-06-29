package com.ycjh.common.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/resource/**")
//                .addResourceLocations("/");

                // multi resource path
                //.addResourceLocations("/resources/","classpath:/other-resources/");s

                // file system
                //.addResourceHandler("/files/**")
                //.addResourceLocations("file:/opt/files/");

                // path resolover
                //.setCachePeriod(3600)
                //.resourceChain(true)
                //.addResolver(new PathResourceResolver());
    }
}
