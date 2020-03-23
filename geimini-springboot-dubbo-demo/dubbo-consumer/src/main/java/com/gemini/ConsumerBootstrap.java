package com.gemini;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini
 * @classname: ConsumerBootstrap
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/23 10:47
 */
@EnableDubboConfiguration
@SpringBootApplication
public class ConsumerBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerBootstrap.class);
    }
}

