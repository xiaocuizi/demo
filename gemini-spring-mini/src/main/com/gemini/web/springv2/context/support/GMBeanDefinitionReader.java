package com.gemini.web.springv2.context.support;

import com.gemini.web.springv2.Utils;
import com.gemini.web.springv2.beans.GMBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.context.support
 * @classname: GMBeanDefinitionReader
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/17 17:13
 */
public class GMBeanDefinitionReader {

    private Properties properties =  new Properties();

    private List<String> registoryBeanClasses = new ArrayList<String>();
    public GMBeanDefinitionReader(String... locations) {
        //TODO
        InputStream inputStream  = Thread.currentThread().
                getContextClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream !=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        doScanner(properties.getProperty("scanPackage"));
    }

    public GMBeanDefinition registerBean(String className) {
        if (this.registoryBeanClasses.contains(className)) {
            GMBeanDefinition beanDefinition = new GMBeanDefinition();
            //这个是全路径宝
            beanDefinition.setBeanClassName(className);
            System.out.println("-------------------");
            System.out.println("className="+className);
            beanDefinition.setFactoryBeanName(Utils.lowerFirstCase(className.substring(className.lastIndexOf(".") + 1)));
            return beanDefinition;
        }
        return null;
    }

  public Properties getProperties(){
          return properties;
    }

    public List<String> loadBeanDdfinitions(){
        return this.registoryBeanClasses;
    }


    /**
     * 递归扫描所有相关的类，并且保存到regstoryBeanClasses中
     * @param packName
     */
    private void doScanner(String packName) {
        //URL url =  this.getClass().getClassLoader().getResource(packName);
        System.out.println(packName);
        URL url = Thread.currentThread().getContextClassLoader().getResource( "/"+packName.replaceAll("\\.","/"));
        File classDir = new File(url.getFile());
        for (File file:classDir.listFiles()){
            if(file.isDirectory()){
                doScanner(packName+"."+file.getName());
            }else {
                System.out.println(packName+"."+file.getName());
                registoryBeanClasses.add(packName+"."+file.getName().replace(".class",""));
            }
        }
    }

}
