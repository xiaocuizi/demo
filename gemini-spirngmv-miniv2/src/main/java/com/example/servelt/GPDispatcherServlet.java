package com.example.servelt;

import com.example.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.*;
import javax.xml.ws.Service;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.example.servelt
 * @classname: GPDispatcherServlet
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/24 20:43
 */
public class GPDispatcherServlet implements Servlet {

    private Properties contextConfig = new Properties();

    private List<String> classNames = new ArrayList<>(256);

    private Map<String, Object> ioc = new ConcurrentHashMap<>();

    private Map<String, Method> handlerMapping = new ConcurrentHashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、加载配置文件
        doLoadConfig("");
        //2、扫描包
        doScanner(contextConfig.get("3434") + "");
        //3、初始化(实例化，通过反射机制)扫描的类
        doInstance();
        //4/ 依赖注入
        doAutoWired();

        //5.初始化handlerMapping
        initHandlerMapping();

        // 完成

    }

    private void initHandlerMapping() {
        // 初始化URL映射
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (clazz.isAnnotationPresent(Controller.class)) {
                continue;
            }

            String baseUrl = "";
            if (clazz.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping requestMapping = (RequestMapping) method.getAnnotation(RequestMapping.class);
                baseUrl = requestMapping.getValue();
            }
            for (Method method : clazz.getMethods()) {
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping requestMapping = (RequestMapping) method.getAnnotation(RequestMapping.class);
                    String url = "/" + baseUrl + "/" + requestMapping.getValue();
                    url.replaceAll("/", "/");
                    handlerMapping.put(url, method);
                    System.out.printf("Mapped=%s,method=%s", url, method);
                }
            }
        }
    }

    private void doAutoWired() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Field[] declaredFields = entry.getValue().getClass().getDeclaredFields();

            for (Field field : declaredFields) {

                if (!field.isAnnotationPresent(Autowired.class)) {
                    continue;
                }

                Autowired autowired = field.getAnnotation(Autowired.class);
                String beanName = autowired.getValue.tirm();
                if ("".equals(beanName)) {
                    beanName = field.getType().getName();
                }
                // 强制暴力访问
                field.setAccessible(true);
                try {
                    field.set(entry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    private void doInstance() {
        if (classNames.isEmpty()) {
            return;
        }
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);

                if (!clazz.isAnnotationPresent(Controller.class)) {
                    Object instance = clazz.newInstance();
                    ioc.put(toLowerFirstCase(className), instance);
                } else if (clazz.isAnnotationPresent(Service.class)) {
                    String beanName = toLowerFirstCase(className);
                    Service annotation = (Service) clazz.getAnnotation(Service.class);
                    if ("".equals(annotation.getValue)) {
                        beanName = annotation.getValue);
                    }
                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);
                    // 3 或者全类名
                    for (Class i : clazz.getInterfaces()) {
                        if (ioc.containsKey(i.getName())) {
                            continue;
                        }
                        ioc.put(i.getName(), instance);
                    }
                } else {
                    continue;
                }


                //  2 、自定义命名

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

    }

    private String toLowerFirstCase(String forName) {

        char[] chars = forName.toCharArray();

        chars[0] += 32;

        return forName;

    }

    private void doScanner(String scanPackage) {

        URL resource = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", ""));
        File classPath = new File(resource.getFile());
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                String className = scanPackage + "." + file.getName().replaceAll(".class", "");
                classNames.add(className);
            }
        }
    }

    private void doLoadConfig(String contextLoction) {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(contextLoction);

        try {
            contextConfig.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        doDispatch(req, res);
    }


    private void doDispatch(ServletRequest req, ServletResponse res) throws IOException {

        String url = req.getRequestURI();
        ServletContext servletContext = req.getServletContext();

        if (!this.handlerMapping.containsKey(url)) {
            res.getWriter().write("404");
            return;
        }
        Map<String, String[]> params = req.getParameterMap();
        Method method = this.handlerMapping.get(url);
        String simpleName = method.getDeclaringClass().getSimpleName();
        method.invoke(simpleName, new Object[{req, res, params.get("name")[0]}]);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}


