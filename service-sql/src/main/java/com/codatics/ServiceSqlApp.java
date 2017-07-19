package com.codatics;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by zeldris on 19/07/17.
 */
@Configuration
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@EntityScan(basePackages = "com.codatics.entity")
@ComponentScan("com.codatics")
class ServiceSqlApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSqlApp.class, args);
    }
}
