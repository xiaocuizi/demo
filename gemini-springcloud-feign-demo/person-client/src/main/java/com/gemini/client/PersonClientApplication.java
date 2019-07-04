package com.gemini.client;

import com.gemini.client.ribbon.MyRule;
import com.gemini.domain.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

/**
 * @author xiaocuzi
 * @package com.gemini.client
 * @classname: PersonClientApplication
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/1 15:58
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = PersonService.class)
//@RibbonClient(value = "person-service",configuration = PersonClientApplication.class)
@EnableHystrix
public class PersonClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class,args);
    }

    @Bean
    public MyRule getMyIRule(){
        return new MyRule();
    }
}
