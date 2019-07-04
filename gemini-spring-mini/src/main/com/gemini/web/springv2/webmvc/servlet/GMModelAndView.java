package com.gemini.web.springv2.webmvc.servlet;


import java.util.Map;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.webmvc.servlet
 * @classname: GMModelAndView
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/21 15:51
 */
public class GMModelAndView {

    private String viewName;
    private Map<String, ?> model;
    public GMModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
        if (model != null) {
            //getModelMap().addAllAttributes(model);
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }

    public void setModel(Map<String, ?> model) {
        this.model = model;
    }
}
