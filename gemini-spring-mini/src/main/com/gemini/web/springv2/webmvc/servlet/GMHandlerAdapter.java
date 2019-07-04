package com.gemini.web.springv2.webmvc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.webmvc.servlet
 * @classname: GMHandlerAdapter
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/21 15:57
 */

/**
 * handler包含了controller，method,url信息
 */
public class GMHandlerAdapter {

    private Map<String,Integer> paramMapping ;


    /**
     *
     * @param req
     * @param resp
     * @param handler
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public GMModelAndView handle(HttpServletRequest req, HttpServletResponse resp, GMHandlerMapping handler) throws InvocationTargetException, IllegalAccessException {
        //根据用户请求的参数信息，跟method中的参数信息进行动态绑定
        //拿到形参列表
        Class<?>[] parameterTypes = handler.getMethod().getParameterTypes();
        //拿到自定义命名参数所在的位置
        Map<String, String[]> reqParameterMap = req.getParameterMap();
        //构造实例列表
        Object[] paramValuse = new Object[parameterTypes.length];
        for (Map.Entry<String, String[]> param : reqParameterMap.entrySet()) {
            String value = Arrays.toString(param.getValue()).replaceAll("\\{|}", "").replaceAll("\\s", ",");
            if (!this.paramMapping.containsKey(param.getKey())) {
                continue;
            }
            int index = this.paramMapping.get(param.getKey());
            //页面上传递过来的值都是String类型的，然而方法中的值都是多样的，所以需要做类型转换
            paramValuse[index] = caseStringValue(value, parameterTypes[index]);

        }
        if (this.paramMapping.containsKey(HttpServletRequest.class.getName())) {
            int reqIndex = this.paramMapping.get(HttpServletRequest.class.getName());
            paramValuse[reqIndex] = req;
        }
        if (this.paramMapping.containsKey(HttpServletResponse.class.getName())) {
            int repIndex = this.paramMapping.get(HttpServletResponse.class.getName());
            paramValuse[repIndex] = resp;
        }
        //从handler中取出controller、method，然后利用反射机制进行调用
        Object result = handler.getMethod().invoke(handler.getController(), paramValuse);
        if (result == null) {
            return null;
        }
        if (handler.getMethod().getReturnType() == GMModelAndView.class) {
            return (GMModelAndView) result;
        }
        return null;
    }


    /**
     *
     * @param value
     * @param clazz
     * @return
     */
    private Object caseStringValue(String value, Class<?> clazz) {
        if(clazz ==String.class){
            return value;
        }else if(clazz ==Integer.class){
            return Integer.valueOf(value);
        }else if(clazz ==int.class){
            return Integer.valueOf(value).intValue();
        }else {
            return null;
        }

    }

    public GMHandlerAdapter(Map<String, Integer> paramMapping) {
        this.paramMapping = paramMapping;
    }

    public Map<String, Integer> getParamMapping() {
        return paramMapping;
    }

    public void setParamMapping(Map<String, Integer> paramMapping) {
        this.paramMapping = paramMapping;
    }
}
