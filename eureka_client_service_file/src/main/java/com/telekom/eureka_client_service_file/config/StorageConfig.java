package com.telekom.eureka_client_service_file.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "storage")
public class StorageConfig {

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
