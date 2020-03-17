package com.gemni.agent;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemni.agent
 * @classname: MyIntercetor
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/16 18:26
 */
public class MyIntercetor {


    @RuntimeType
    public static Object intercept(@Origin Method method, @SuperCall Callable<?> callable) throws Exception {
        Long start = System.currentTimeMillis();
        try {
            return callable.call();
        } finally {
            System.out.println("method name=" + method.getName() + ",cost time=" + (System.currentTimeMillis() - start));
        }

    }
}


