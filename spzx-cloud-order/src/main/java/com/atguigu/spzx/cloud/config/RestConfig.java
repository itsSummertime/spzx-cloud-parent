package com.atguigu.spzx.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Bean //将方法的返回值存入Spring容器
    @LoadBalanced //启用负载均衡的功能，可以通过服务名远程调用
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
