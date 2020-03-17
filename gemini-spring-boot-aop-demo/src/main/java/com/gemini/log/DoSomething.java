package com.gemini.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiaocuzi
 * @package com.gemini.log
 * @classname: DoSomethind
 * @description: todo (用一句话描述该文件做什么)
 * @date 2020/1/19 21:28
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoSomething {
    String key();

    String val();

    int exTime();

    boolean needLog() default false;
}
