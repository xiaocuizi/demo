package com.gemini.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaocuzi
 * @package com.gemini.event
 * @classname: EventController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2020/1/20 14:43
 * @since 1.0.0
 */
@RestController
public class EventController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/index/{name}")
    public String login(@PathVariable("name") String name) {

        Map<String, Object> source = new HashMap<>();
        source.put("name", name);
        applicationContext.publishEvent(new LogEvent(source));
        return "success";
    }
}
