package com.gemini.web.springv2.beans;

import com.sun.istack.internal.Nullable;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.beans
 * @classname: GMBeanPostProcessor
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/17 18:49
 */
public class GMBeanPostProcessor {


    /**
     * 执行方之前doSth
     * @param bean
     * @param beanName
     * @return
     * @throws Exception
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    /**
     * 执行方法之后doSth
     * @param bean
     * @param beanName
     * @return
     * @throws Exception
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}
