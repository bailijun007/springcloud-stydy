package com.blj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//Eureka Server服务器端启动类，代表可以接受其他服务注册进来。
public class Config_Git_EurekaServer7001_App {
    public static void main(String[] args) {
        SpringApplication.run(Config_Git_EurekaServer7001_App.class,args);
    }
}
