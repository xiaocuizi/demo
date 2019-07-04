package com.gemini.web.springv1.servlet;


import com.gemini.web.springv1.annotation.GMAutoWried;
import com.gemini.web.springv1.annotation.GMController;
import com.gemini.web.springv1.annotation.GMService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package main.com.gemini.web.springv1.servlet
 * @classname: GMDispatchServlet
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/16 11:43
 */
public class GMDispatchServlet extends HttpServlet {

    private Properties contextConfig = new Properties();

    private Map<String, Object> beanMap = new ConcurrentHashMap<String, Object>(256);

    private List<String> classNames = new ArrayList<String>();

    public GMDispatchServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----------------doGet-------------");
        this.doPost(req, resp);
    }

    @java.lang.Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----------------doPost-------------");
    }

    @java.lang.Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //定位  #  contextConfig
        doLocation(servletConfig.getInitParameter("contextLocation"));
        //加载  # classNams
        doScanner(contextConfig.getProperty("scanPackage"));
        //注册
        doRegistory();  //BeanMap
        //依赖注入,在spring中是通过getBean方法才会触发注入的
        doAutoWired();  // field.setAccessible(true);
        //mvc
        doHandlerMapping();
    }

    private void doHandlerMapping() {
    }

    private void doRegistory() {
        if (classNames.isEmpty()) {
            return;
        }
        for (String className : classNames) {
            //反射
            try {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(GMController.class)) {
                    String beanName = lowerFirstCase(clazz.getSimpleName());
                    beanMap.put(beanName, clazz.newInstance());
                } else if (clazz.isAnnotationPresent(GMService.class)) {
                    GMService service = clazz.getAnnotation(GMService.class);
                    //默认用类名首字母注入
                    //如果自己定义了beanName ,那么优先使用自己定义的beanName
                    String beanName = service.value();
                    System.out.println("=========================");
                    System.out.println("SimpleName=" + clazz.getSimpleName() + "===========name=" + clazz.getName());
                    System.out.println("=========================");
                    if ("".equals(beanName)) {
                        beanName = lowerFirstCase(clazz.getSimpleName());
                    }
                    Object instance = clazz.newInstance();
                    beanMap.put(beanName, instance);
                    Class<?>[] interfaces = clazz.getInterfaces();
                    for (Class<?> i : interfaces) {
                        beanMap.put(i.getName(), instance);
                    }
                } else {
                    continue;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        }
    }

    private void doAutoWired() {
        if (beanMap.isEmpty()) {
            return;
        }
        for (Map.Entry entry : beanMap.entrySet()) {
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(GMAutoWried.class)) {
                    GMAutoWried gmAutoWried = field.getAnnotation(GMAutoWried.class);
                    String beanName = gmAutoWried.value();
                    if ("".equals(beanName)) {
                        beanName = field.getType().getName();
                    }
                    field.setAccessible(true);
                    try {
                        field.set(entry.getValue(), beanMap.get(beanName));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void doScanner(String packName) {
        //URL url =  this.getClass().getClassLoader().getResource(packName);
        System.out.println(packName);
        URL url = Thread.currentThread().getContextClassLoader().getResource("/" + packName.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(packName + "." + file.getName());
            } else {
                System.out.println(packName + "." + file.getName());
                classNames.add(packName + "." + file.getName().replace(".class", ""));
            }
        }
        classNames.size();
    }

    private void doLocation(String location) {
        //读取配置文件
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(location);
        try {
            contextConfig.load(inputStream);
            inputStream.close();
            inputStream = null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String lowerFirstCase(String source) {
        System.out.println("=====================================");
        System.out.println(source);
        System.out.println("=====================================");
        char[] chars = source.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
