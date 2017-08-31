package com.zsk.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author Lion Weng
 * @date 2017-08-13
 * @version v1.0.0
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class, args);
    }
}