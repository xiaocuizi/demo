package com.gemini.web.springv2.context;

import com.gemini.web.springv2.beans.GMBeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.context
 * @classname: GMDefaultListableBeanFactory
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/23 11:24
 */
public class GMDefaultListableBeanFactory extends GMAbstractApplicationContext {

    /** Map of bean definition objects, keyed by bean name. */
    //传说已久的IOC容器
    private final Map<String, GMBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    protected void onRefresh(){

    }
    @Override
    protected void refreshBeanFactory() throws Exception {

    }
}
