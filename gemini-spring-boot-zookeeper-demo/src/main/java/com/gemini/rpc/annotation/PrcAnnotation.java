package com.gemini.rpc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.rpc.annotation
 * @classname: PrcAnnotation
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/22 15:11
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrcAnnotation {

    /**
     * 发布的服务接口地址
     * @return
     */
    Class<?> value();
}


