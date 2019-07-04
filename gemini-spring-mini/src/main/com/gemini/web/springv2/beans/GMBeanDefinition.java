package com.gemini.web.springv2.beans;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.beans
 * @classname: GMBeanDefinitionReader
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/17 15:21
 */

/**
 * 用量存储配置文件中的信息
 * 用于保存到内存中
 */
public class GMBeanDefinition {

    private String beanClassName;
    private boolean lazyInit = false;

    private String  factoryBeanName;

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }

    /*//
    public void setBeanClassName(String beanClassName){

    }

    public String getBeanClassName(){

        return null;
    }

    public void setFactoryBeanName(String factoryBeanName){

    }

    public String getFactoryBeanName(){
        return null;
    }

    void setLazyInit(boolean lazyInit){

    }

    *//**
     * Return whether this bean should be lazily initialized, i.e. not
     * eagerly instantiated on startup. Only applicable to a singleton bean.
     *//*
    boolean isLazyInit(){
        return false;
    }*/


}
