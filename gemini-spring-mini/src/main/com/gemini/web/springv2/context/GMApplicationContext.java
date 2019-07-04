package com.gemini.web.springv2.context;

import com.gemini.web.springv2.annotation.GMAutoWried;
import com.gemini.web.springv2.annotation.GMController;
import com.gemini.web.springv2.annotation.GMService;
import com.gemini.web.springv2.aop.GMAopConfig;
import com.gemini.web.springv2.beans.GMBeanDefinition;
import com.gemini.web.springv2.beans.GMBeanPostProcessor;
import com.gemini.web.springv2.beans.GMBeanWrapper;
import com.gemini.web.springv2.context.support.GMBeanDefinitionReader;
import com.gemini.web.springv2.core.GMBeanFactory;
import com.gemini.web.springv2.demo.BetaController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.context
 * @classname: GMApplicationContext
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/17 14:41
 */
public class GMApplicationContext extends GMDefaultListableBeanFactory implements GMBeanFactory {

    public GMApplicationContext() {

    }

    private String[] locations;

    private GMBeanDefinitionReader reader;


    /**
     * 保存配置信息
     * //一个首字母小写的javabean
     */
    private Map<String, GMBeanDefinition> beanDefinitionMap = new ConcurrentHashMap();

    /**
     * 保证注册式单例
     */
    private Map<String, Object> beanCacheMap = new ConcurrentHashMap();

    private Map<String, GMBeanWrapper> beanWrapperMap = new ConcurrentHashMap<String, GMBeanWrapper>();

    public GMApplicationContext(String[] locations) {
        this.locations = locations;
        this.refresh();
    }

    public void refresh(String... locations) {
        //定位
        this.reader = new GMBeanDefinitionReader(locations);
        //加载
        List<String> beanDefinitions = reader.loadBeanDdfinitions();
        //注册
        doRegistory(beanDefinitions);
        //依赖注入（lazy-init =false ）要执行依赖注入
        //在这里自动调用getBean方法
        doAutoWired(beanDefinitions);
        //TODO
       /* try {
            BetaController betaController = (BetaController) getBean("betaController");
            betaController.say();
            System.out.println("xxxxxxxxxxxxxxxxxx");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    /**
     * 自动注入
     * 1、拿到相应的
     * 2、注入到
     */
    private void doAutoWired(List<String> beanDefinitions) {
        try {
            for (Map.Entry<String, GMBeanDefinition> entry : beanDefinitionMap.entrySet()) {
                String beanName = entry.getKey();
                if (!entry.getValue().isLazyInit()) {
                   Object object =  getBean(beanName);
                    System.out.println("object="+object.getClass());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 构建bean
     *
     * @param beanName
     * @param instance
     */
    private void populateBean(String beanName, Object instance) {
        Class<?> clazz = instance.getClass();
        if (!(clazz.isAnnotationPresent(GMService.class) || clazz.isAnnotationPresent(GMController.class))) {
            return;
        }
        try {
            Field[] fields = clazz.getDeclaredFields();
            if (fields == null || fields.length <= 0) {
                return;
            }
            for (Field field : fields) {
                if (!field.isAnnotationPresent(GMAutoWried.class)) {
                    continue;
                }
                GMAutoWried gmAutoWried = field.getAnnotation(GMAutoWried.class);
                String autoWriedBeanName = gmAutoWried.value();//全路径
                if ("".equals(autoWriedBeanName)) {
                    autoWriedBeanName = field.getType().getName();
                }
                field.setAccessible(true);
                //TODO
                Object value = null;
                if (this.beanWrapperMap.get(autoWriedBeanName) == null) {
                    GMBeanDefinition gmBeanDefinition = beanDefinitionMap.get(autoWriedBeanName);
                    value = (Object) com.gemini.web.springv2.Utils.createBeanWithReflection(gmBeanDefinition.getBeanClassName());
                } else {
                    value = this.beanWrapperMap.get(autoWriedBeanName).getWrapperInstance();
                }
                if (value == null) {
                    throw new RuntimeException("注属性失败。");
                }
                field.set(instance, value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * beanDefinition注册到IOC容器中bedifitionMap
     *
     * @param beanDefinitions
     */
    private void doRegistory(List<String> beanDefinitions) {
        try {
            for (String className : beanDefinitions) {
                Class<?> beanClass = Class.forName(className);
                //如果时候接口的话，用的实现类进行实例化
                //1 默认首字母小写
                if (beanClass.isInterface()) {
                    continue;
                }
                GMBeanDefinition beanDefinition = reader.registerBean(className);
                if (beanDefinition != null)
                    beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
                //2、自定义

                //3接口注入,则实例化它的实现类
                Class<?>[] interfaces = beanClass.getInterfaces();
                for (Class<?> clazz : interfaces) {
                    beanDefinitionMap.put(clazz.getName(), beanDefinition);
                }

                //容器初始化完毕，如果是多个实现的话，可能被覆盖
                //可以指定名字
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * getBean方法，获取一个对象的实例
     *
     * @param name
     * @return
     * @throws Exception
     */
    /**
     * 通过读取definition中的信息
     * 然后通过反射机制创建一个实例并且返回
     * 不会把原始的对象放出去，而是利用warpperImpl进行的包装
     * 装饰器模式：
     * 保留了原始的bean
     * 可以自由扩展
     *
     * @param beanName
     * @return
     * @throws Exception
     */
    public Object getBean(String beanName) throws Exception {
        GMBeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        String className = beanDefinition.getBeanClassName();
        //TODO 生成通知事件
        GMBeanPostProcessor postProcessor = new GMBeanPostProcessor();
        //要保证单例
        Object instance = instantionBean(beanDefinition);
        if (instance == null) {
            return null;
        }
        //TODO
        postProcessor.postProcessBeforeInitialization(instance, beanName);
        GMBeanWrapper gmBeanWrapper = new GMBeanWrapper(instance);
        gmBeanWrapper.setConfig(instantionAopConifg(beanDefinition));
        beanWrapperMap.put(beanName, gmBeanWrapper);
        //TODO 之后通知一下
        postProcessor.postProcessAfterInitialization(instance, beanName);
        //TODO 相当于留有了可操作的空间，以后备用
        populateBean(beanName, instance);
        return this.beanWrapperMap.get(beanName).getWrapperInstance();
    }


    /**
     * 初始化一个bean
     *
     * @param beanDefinition
     * @return
     */
    public Object instantionBean(GMBeanDefinition beanDefinition) {
        Object instance = null;
        String className = beanDefinition.getBeanClassName();
        try {

            if (this.beanCacheMap.containsKey(className)) {
                instance = beanCacheMap.get(className);
            } else {
                Class<?> clazz = Class.forName(className);
                //TODO 这里需要处理抽象类
                try {
                    instance = clazz.newInstance();
                    beanCacheMap.put(className, instance);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public int getBeanDefinitionCount() {
       return this.beanDefinitionMap.size();
    }

    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public Properties getConfig() {
        return this.reader.getProperties();
    }


    /**
     *
     * @param beanDefinition
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     */
    public GMAopConfig instantionAopConifg(GMBeanDefinition beanDefinition) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        GMAopConfig aopConfig = new GMAopConfig();
        //TODO
        String expression = this.reader.getProperties().getProperty("pointCut");
        String[] aspectBefore = this.reader.getProperties().getProperty("aspectBefore").split("\\s");
        String[] aspectAfter = this.reader.getProperties().getProperty("aspectAfter").split("\\s");

        String className = beanDefinition.getBeanClassName();
        Class<?> clazz = Class.forName(className);
        Pattern pattern = Pattern.compile(expression);
        Class<?> aspectBeforeClazz = Class.forName(aspectBefore[0]);
        //System.out.println(expression);
        //这里是原始的方法
        for (Method method : clazz.getMethods()) {
            //System.out.println(method.toString());
            Matcher matcher = pattern.matcher(method.toString());
            //public .* com\.gemini\.web\.springv2\.demo\..*Service\..*\(.*\)
            //public java.lang.String com.gemini.web.springv2.demo.BetaService.say(String name)
            if (matcher.matches()) {
                //Method target, Object aspect, Method[] points
                aopConfig.put(method,
                        aspectBeforeClazz.newInstance(),
                        new Method[]{aspectBeforeClazz.getMethod(aspectBefore[1]), aspectBeforeClazz.getMethod(aspectAfter[1])});
            }
        }
        return aopConfig;
    }

}
