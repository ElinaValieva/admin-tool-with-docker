package com.telekom.eureka_client_service_a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientServiceAApplication.class, args);
    }
}
