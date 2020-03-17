package com.gemini.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author xiaocuzi
 * @package com.gemini.event
 * @classname: LogEvent
 * @description: todo (用一句话描述该文件做什么)
 * @date 2020/1/20 15:02
 * @since 1.0.0
 */
public class LogEvent extends ApplicationEvent {
    public LogEvent(Object source) {
        super(source);
    }
}
