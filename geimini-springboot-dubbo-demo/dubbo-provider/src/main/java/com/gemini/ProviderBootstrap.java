package com.gemini;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini
 * @classname: ProviderBootstrap
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/23 10:41
 */
@EnableDubboConfiguration
@SpringBootApplication
public class ProviderBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ProviderBootstrap.class, args);
    }

}
