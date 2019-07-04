package com.gemini.web.springv2.aop;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.aop
 * @classname: GMAopProxy
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/23 11:40
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 默认使用JDK动态代理
 */
public class GMAopProxy implements InvocationHandler {
    public GMAopProxy() {}
    public GMAopConfig config;

    private Object target;

    public void setConfig(GMAopConfig config) {
        this.config = config;
    }
    /**
     *
     * @param instance 原生的对象
     * @return
     */
   public Object getProxy(Object instance){
       this.target =instance;
       Class<?> clazz = instance.getClass();
       return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
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
        //这里要得到原始的方法 对应：com.gemini.web.springv2.context.GMApplicationContext.instantionAopConifg
        Method originalMethod = this.target.getClass().getMethod(method.getName(),method.getParameterTypes());
        if (config.contains(originalMethod)) {
            //调用原始方法之前doSth，即增强代码
            GMAopConfig.GMAspect aspect = config.get(originalMethod);
            aspect.getPoints()[0].invoke(aspect.getAspect());
        }

        //这里调用原始方法
        Object object = method.invoke(this.target, args);

        if (config.contains(originalMethod)) {
            //调用方法之后doSth
            GMAopConfig.GMAspect aspect = config.get(originalMethod);
            aspect.getPoints()[1].invoke(aspect.getAspect());
        }
        return object;
    }
}
