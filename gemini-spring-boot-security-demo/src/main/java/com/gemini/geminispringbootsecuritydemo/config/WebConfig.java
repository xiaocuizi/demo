package com.gemini.geminispringbootsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.geminispringbootsecuritydemo.config
 * @classname: WebConfig
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/19 19:21
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("redirect:/login-view");
            registry.addViewController("/login-view").setViewName("login");

        }
}


