package com.ycjh.file.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:ycjh.properties")
@ConfigurationProperties(prefix = "file")
public class FilePropertiesConfig {


    private static String baseDir;
    private String maxSize;
    private String available;

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getMaxSize() {
        return maxSize;
    }
    public String getAvailable() {
        return available;
    }

    public static String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }
}

