package com.telekom.eureka_client_service_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientServiceBApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientServiceBApplication.class, args);
    }
}
