package com.gemini.spring;

import com.gemini.spring.service.EchoService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring
 * @classname: SpringAppcation
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/18 17:04
 */
@ComponentScan(basePackages = "com.gemini.spring")
public class SpringAppcation {


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringAppcation.class);
        applicationContext.refresh();
        applicationContext.getBeansOfType(EchoService.class).forEach((beanName, bean) -> {
            System.out.println("=====================================");
            System.out.println("Bean Name :" + beanName + ",bean=" + bean);
            bean.say("hi~~~");
            System.out.println("=====================================");
        });
        applicationContext.close();
    }

}
