package com.gemini.web.springv2.core;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.core
 * @classname: GMBeanFactory
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/17 14:43
 */
public interface GMBeanFactory {

    /**
     * getBean方法，获取一个对象的实例
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name) throws Exception;
}
