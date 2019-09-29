package com.blj.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    //这里面编写自定义的负载均衡算法，
    // 这里就简单直接还是用Ribbon内置的算法作为演示

    @Bean
    public IRule getMySelfRule(){
        return new RandomRule();//随机算法,（Ribbon内置的算法）
       // return new MyRandomRule();//自定义规则（自己定义的算法）
    }

}
