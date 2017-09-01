package com.zsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author connor-zheng
 * @date 2017-08-15
 * @version v1.0.0
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApp.class, args);
    }
}