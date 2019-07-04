package com.gemini.web.springv2.beans;

import com.gemini.web.springv2.aop.GMAopConfig;
import com.gemini.web.springv2.aop.GMAopProxy;
import com.gemini.web.springv2.core.GMFactoryBean;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.beans
 * @classname: GMBeanWrapper
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/17 15:22
 */
public class GMBeanWrapper extends GMFactoryBean {

    private GMAopConfig aopConfig;

    private GMAopProxy  proxy = new GMAopProxy();

    /**
     * 观察者模式，支持事件响应
     * 监听机制
     * Bean
     */
    private GMBeanPostProcessor beanPostProcessor;
    private Object wrapperInstance;

    private Object originalInstance;

    /**
     * TODO spring操作的是代理对象
     * @param instance
     */
    public GMBeanWrapper(Object instance) {
        this.originalInstance = instance;
        //this.wrapperInstance = instance;
        this.wrapperInstance = proxy.getProxy(instance);
    }


    /**
     * 返回以后的Class
     * 可能会是$proxy0
     * @return
     */
    public final Class<?> getWrappedClass() {
        return wrapperInstance.getClass();
    }


    public Object getWrapperInstance() {
        return wrapperInstance;
    }

    public void setWrapperInstance(Object wrapperInstance) {
        this.wrapperInstance = wrapperInstance;
    }

    public Object getOriginalInstance() {
        return originalInstance;
    }

    public void setOriginalInstance(Object originalInstance) {
        this.originalInstance = originalInstance;
    }

    public void setConfig(GMAopConfig config) {
        proxy.setConfig(config);
    }
}
