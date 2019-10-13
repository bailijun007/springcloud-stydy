package com.blj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient//本服务启动后会自动注册到Eureka服务中
@SpringBootApplication
@EnableDiscoveryClient //对于注册进eureka里面的服务，可以通过服务发现获得该服务的信息
public class Config_DeptProvider8001_App {
    public static void main(String[] args) {
        SpringApplication.run(Config_DeptProvider8001_App.class,args);
    }
}
