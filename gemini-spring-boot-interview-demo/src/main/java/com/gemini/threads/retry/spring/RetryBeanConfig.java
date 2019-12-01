package com.gemini.threads.retry.spring;

import com.google.common.collect.Maps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.Map;

/**
 * @author xiaocuzi
 * @package com.gemini.threads.retry.spring
 * @classname: RetryBeanConfig
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/12/1 16:14
 * @since 1.0.0
 */
@Configuration
public class RetryBeanConfig {
    @Bean
    public RetryTemplate timeoutRetryTemplate() {
        TimeoutRetryPolicy timeRetryPolicy = new TimeoutRetryPolicy();
        timeRetryPolicy.setTimeout(5000L);
        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(timeRetryPolicy);
        return retryTemplate;
    }

    @Bean
    public RetryTemplate countRetryTemplate() {
        Map<Class<? extends Throwable>, Boolean> proxyMap = Maps.newHashMap();
        proxyMap.put(DBUpdateConflictException.class, Boolean.TRUE);
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy(3, proxyMap);
        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(simpleRetryPolicy);
        return retryTemplate;
    }
}
