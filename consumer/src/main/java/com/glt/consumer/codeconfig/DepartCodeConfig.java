package com.glt.consumer.codeconfig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DepartCodeConfig {

    // 固定URL请求
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //eureka rest请求
    @LoadBalanced
    @Bean
    public RestTemplate getLoadBalancedRestTemplate(){
        return new RestTemplate();
    }
}
