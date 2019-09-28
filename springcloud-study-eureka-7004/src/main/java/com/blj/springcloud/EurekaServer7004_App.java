package com.blj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7004_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7004_App.class,args);
    }

}
