package com.gemini.core.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.proxy
 * @classname: CglibDynamicProxy
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/8 9:41
 */
public class CglibDynamicProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("日志记录开始");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("日志记录结束");
        return result;
    }
}


