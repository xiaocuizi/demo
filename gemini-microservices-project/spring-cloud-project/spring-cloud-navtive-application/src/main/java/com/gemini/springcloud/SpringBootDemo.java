package com.gemini.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package cloud
 * @classname: SpringBootDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/21 10:49
 */
@EnableAutoConfiguration
@RestController
public class SpringBootDemo {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.setId("小崔子");
        context.registerBean("helloWorld",String.class,"hello,World~~");
        //启动
        context.refresh();

        new SpringApplicationBuilder(SpringBootDemo.class)
                .parent(context)
                .run(args);


        //SpringApplication.run(SpringBootDemo.class,args);
    }

    @Autowired
    @Qualifier("helloWorld")
    private String msg;


    @GetMapping
    public String index(){
        return msg;
    }
}
