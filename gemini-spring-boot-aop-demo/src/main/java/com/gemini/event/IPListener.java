package com.gemini.event;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xiaocuzi
 * @package com.gemini.event
 * @classname: LogListener
 * @description: todo (用一句话描述该文件做什么)
 * @date 2020/1/20 15:03
 * @since 1.0.0
 */
@Order(45)
@Component
public class IPListener implements ApplicationListener<LogEvent> {
    @Override
    public void onApplicationEvent(LogEvent logEvent) {
        Map source = (Map) logEvent.getSource();
        System.out.println("打印IP " + source.get("name") + " 127.0.01");
    }
}
