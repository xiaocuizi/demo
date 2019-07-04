package com.gemini.drivenannotation;

import com.gemini.config.UserConfiguratiion;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.drivenannotation
 * @classname: XmlConfigBootstrap
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/22 19:57
 */
public class AnnotationConfigBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(UserConfiguratiion.class);
        context.refresh();

        User user = context.getBean("user", User.class);
        System.out.println(user.toString());

    }
}


