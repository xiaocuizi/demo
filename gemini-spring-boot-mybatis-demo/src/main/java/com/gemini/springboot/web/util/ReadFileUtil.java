package com.gemini.springboot.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.springboot.web.util
 * @classname: ReadFileUtil
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/12 17:47
 */
public class ReadFileUtil {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Properties preferences = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("开始获取输入流。。。。。。。。。。");
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");
        try {
            preferences.load(inputStream);
            System.out.println("装载配置文件完成。。。。。。。。。。");
            String driverName = preferences.getProperty("spring.datasource.driver-class-name");
            System.out.println("driverName:"+driverName);
            System.out.println("cost:"+(System.currentTimeMillis()-startTime));
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
    }
}
