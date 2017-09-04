package com.zsk.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 
 * @author connor-zheng
 * @date 2017-07-13
 * @version v1.0.0
 * 
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}
