package com.gemini.web.springv2.webmvc.servlet;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.webmvc.servlet
 * @classname: GMHandlerMapping
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/21 15:57
 */
public class GMHandlerMapping {

    private Object controller;

    private Method method;

    private Pattern url;


    public GMHandlerMapping(Pattern url,Object controller, Method method) {
        this.controller = controller;
        this.method = method;
        this.url = url;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getUrl() {
        return url;
    }

    public void setUrl(Pattern url) {
        this.url = url;
    }
}
