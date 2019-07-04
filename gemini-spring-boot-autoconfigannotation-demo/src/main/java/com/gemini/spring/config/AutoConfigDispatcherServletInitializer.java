package com.gemini.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.spring.config
 * @classname: AutoConfigDispatcherServletInitializer
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/23 14:06
 */
public class AutoConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebMvcConfiguration.class};
    }

    protected String[] getServletMappings() {
        return new String[0];
    }
}


