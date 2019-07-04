package com.gemini.springboot.web;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.springboot.web
 * @classname: SystemPropertiesDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/30 10:27
 */
public class SystemPropertiesDemo {
    public static void main(String[] args) {
        String property = System.getProperty("file.encoding");
        System.out.println(property);
    }
}


