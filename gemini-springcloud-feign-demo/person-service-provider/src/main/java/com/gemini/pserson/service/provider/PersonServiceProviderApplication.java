package com.gemini.pserson.service.provider;

import com.sun.jersey.spi.container.servlet.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xiaocuzi
 * @package com.gemini.pserson.service.provider
 * @classname: PersonServiceProviderApplication
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/1 16:15
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EntityScan(basePackages="com.gemini.domain.entity")//这个问题导致，启动无法创建表，不在同一包下面
@EnableTransactionManagement(proxyTargetClass =true)//是不是以接口来做代理
public class PersonServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonServiceProviderApplication.class,args);
    }
}
