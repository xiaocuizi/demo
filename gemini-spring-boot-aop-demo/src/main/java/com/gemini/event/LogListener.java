package com.gemini.event;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author xiaocuzi
 * @package com.gemini.event
 * @classname: LogListener
 * @description: todo (用一句话描述该文件做什么)
 * @date 2020/1/20 15:03
 * @since 1.0.0
 */
@Order(11)
@Component
public class LogListener implements ApplicationListener<LogEvent> {
    @Override
    public void onApplicationEvent(LogEvent logEvent) {
        Map source = (Map) logEvent.getSource();
        System.out.println("打印日志" + source.get("name"));
    }
}
