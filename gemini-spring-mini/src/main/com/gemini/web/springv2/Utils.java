package com.gemini.web.springv2;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2
 * @classname: Utils
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/20 17:34
 */
public class Utils {

    public static String lowerFirstCase(String source){
        System.out.println("=====================================");
        System.out.println("source=>"+source);
        System.out.println("=====================================");
        char[] chars = source.toCharArray();
        chars[0] +=32;
        //chars[4] +=32;
        System.out.println("result=>"+ String.valueOf(chars));
        System.out.println("=====================================");
        return String.valueOf(chars);
    }

    /**
     *
     * @param className
     * @param <T>
     * @return
     */
    public static <T> T createBeanWithReflection(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            return (T) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;

    }
}
