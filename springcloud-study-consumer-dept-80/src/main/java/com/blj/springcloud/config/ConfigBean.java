package com.blj.springcloud.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced//ribbon实现的一套 ==客户端、负载均衡的工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }



}
