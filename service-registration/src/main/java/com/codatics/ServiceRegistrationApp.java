package com.codatics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by zeldris on 19/07/17.
 */
@EnableEurekaServer
@SpringBootApplication
class ServiceRegistrationApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistrationApp.class, args);
    }
}
