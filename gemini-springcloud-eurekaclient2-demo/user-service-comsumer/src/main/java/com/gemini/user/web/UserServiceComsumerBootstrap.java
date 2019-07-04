package com.gemini.user.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.user.web
 * @classname: UserServiceComsumerBootstrap
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/23 18:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceComsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceComsumerBootstrap.class,args);
    }


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
