package com.gemini;

import com.gemini.dubbo.triceid.LogTraceIdFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/10 17:23
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new LogTraceIdFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("logTraceIdFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
