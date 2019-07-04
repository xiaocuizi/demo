package com.gemini.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring
 * @classname: MvcRestApplication
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/18 15:14
 */
@SpringBootApplication
@ComponentScan(basePackages="com.gemini.spring.controller")
public class MvcRestApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(MvcRestApplication.class)
                .properties("server.port=8080").run(args);
    }
}
