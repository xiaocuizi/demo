package com.example.servelt;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.example.servelt
 * @classname: GPDispatcherServlet
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/24 20:43
 */
public class GPDispatcherServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、加载配置文件

        //2、扫描包

        //3、初始化扫描的类

        //4/

        //todo



    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}


