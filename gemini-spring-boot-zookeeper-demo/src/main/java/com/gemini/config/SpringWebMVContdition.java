package com.gemini.config;

import com.gemini.drivenannotation.ConditionOnClass2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.config
 * @classname: SpringWebMVContdition
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/23 15:31
 */
@Configuration
@ComponentScan(basePackages = "com.gemini.config")
public class SpringWebMVContdition {

    @Autowired(required = false)
    @Qualifier("helloWord")
    private String helloWord;

    @ConditionOnClass2(String.class)
    @Bean("helloWorld")
    public String helloWorld(){
        return helloWord;
    }
}


