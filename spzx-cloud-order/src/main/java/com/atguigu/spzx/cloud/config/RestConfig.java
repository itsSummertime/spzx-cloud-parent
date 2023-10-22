package com.atguigu.spzx.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Bean //将方法的返回值存入Spring容器
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
