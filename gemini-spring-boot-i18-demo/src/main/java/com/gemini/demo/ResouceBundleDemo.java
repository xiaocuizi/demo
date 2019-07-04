package com.gemini.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author xiaocuzi
 * @package com.gemini.demo
 * @classname: ResouceBundleDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/30 11:56
 * @since 1.0.0
 */
public class ResouceBundleDemo {

    public static void main(String[] args) throws IOException {

        ResourceBundle bundle = ResourceBundle.getBundle("default");
        Object name = bundle.getString("name");
        System.out.println(name);
        ClassLoader classLoader = ResouceBundleDemo.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("default.properties");
        Reader reader = new InputStreamReader(resourceAsStream);
        PropertyResourceBundle propertyResourceBundle = new PropertyResourceBundle(reader);

        String name1 = propertyResourceBundle.getString("name");
        System.out.println("name1=" + name1);

    }

}
