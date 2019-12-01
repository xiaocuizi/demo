package com.gemini.web;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaocuzi
 * @package com.gemini.web
 * @classname: AccessFilter
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/9/27 20:06
 * @since 1.0.0
 */
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 代表路由被请求之前执行
        return "pre";
    }


    /**
     * 过滤器的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String accessToken = request.getParameter("accessToken");
        if(StringUtils.isBlank(accessToken)){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
