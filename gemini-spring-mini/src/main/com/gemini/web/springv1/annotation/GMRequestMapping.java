package com.gemini.web.springv1.annotation;

import java.lang.annotation.*;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package main.com.gemini.web.springv1.annotation
 * @classname: GMRequestMapping
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/16 12:27
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GMRequestMapping {
    String value() default "";
}
