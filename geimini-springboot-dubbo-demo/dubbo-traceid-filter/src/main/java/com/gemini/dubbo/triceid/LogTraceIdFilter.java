package com.gemini.dubbo.triceid;


import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;

import javax.servlet.*;
import java.io.IOException;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/10 16:46
 */
public class LogTraceIdFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            LogTraceUitls.addTraceId();
            chain.doFilter(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } finally {
            LogTraceUitls.removeTraceId();
        }
    }

    @Override
    public void destroy() {

    }
}
