package com.gemini.spring.cloud;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.cloud
 * @classname: SpringEventDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/22 17:43
 */
public class SpringEventDemo {


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册监听器
        context.addApplicationListener(new ApplicationListener<MyApplicationEvent>() {
            @Override
            public void onApplicationEvent(MyApplicationEvent event) {
                System.out.println("接收事件" + event.getSource());
            }
        });
        //发布事件

        context.refresh();
        context.publishEvent(new MyApplicationEvent("hello"));
        //监听得到事件
    }


    /**
     *
     */
    public static  class MyApplicationEvent extends ApplicationEvent{

        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }
}
