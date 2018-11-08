package com.telekom.eureka_client_service_file;

import com.telekom.eureka_client_service_file.config.StorageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableEurekaClient
@EnableConfigurationProperties(StorageConfig.class)
public class EurekaClientServiceFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientServiceFileApplication.class, args);
    }
}
