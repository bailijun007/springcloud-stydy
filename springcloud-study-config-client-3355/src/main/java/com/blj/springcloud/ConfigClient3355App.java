package com.blj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class ConfigClient3355App {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355App.class,args);
    }

}
