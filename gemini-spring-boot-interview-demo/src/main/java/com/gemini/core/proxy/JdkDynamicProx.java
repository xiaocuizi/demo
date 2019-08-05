package com.gemini.core.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.proxy
 * @classname: JdkDynamicProx
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/8 10:03
 */
public class JdkDynamicProx implements InvocationHandler {

    /**
     * 委托对象
     */
    public Object target;


   public Object bind(Object target) {
        this.target = target;
       Object instance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
       return instance;
   }



    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记录日志开始。。。。。。");
        Object invoke = method.invoke(target, args);
        System.out.println("记录日志结束。。。。。。");
        return invoke;
    }
}


