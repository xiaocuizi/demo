package com.gemini.web.springv2.aop;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.aop
 * @classname: GMAopConfig
 * @description: 只是对expression中表达式的一个封装，目标代理对象的一个方法要增强，由自己实现的业务逻辑去增强
 * 配置文件的目的，就是告诉spring哪些类需要增强，以及增强的目的是什么
 * @date 2019/1/23 12:01
 */
public class GMAopConfig {


    /**
     * 要增强的对象的Method作为key，需要增强的内容作为value
     */
    private Map<Method, GMAspect> points = new ConcurrentHashMap<Method, GMAspect>();

    public void put(Method target, Object aspect, Method[] points) {
        this.points.put(target, new GMAspect(aspect, points));
    }

    public GMAspect get(Method method) {
        return this.points.get(method);
    }

    public boolean contains(Method method) {
        return this.points.containsKey(method);
    }

    /**
     * 将原始对象和方法进行分装
     */
    public class GMAspect{
        private Object aspect;//将logAspect对象赋值给它
        private Method[] points;//会将LogAspect的before和after方法赋值进来

        public GMAspect(Object aspect, Method[] points) {
            this.aspect = aspect;
            this.points = points;
        }

        public Object getAspect() {
            return aspect;
        }

        public void setAspect(Object aspect) {
            this.aspect = aspect;
        }

        public Method[] getPoints() {
            return points;
        }

        public void setPoints(Method[] points) {
            this.points = points;
        }
    }
}
