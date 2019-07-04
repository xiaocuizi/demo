package com.gemini.spring.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.spring.config.controller
 * @classname: DemoController
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/23 14:07
 */
@RestController
public class DemoController {
    @GetMapping("/hello")
    public String index(){
        return "你还会 ‘" +
                "" +
                "" +
                "";
    }
}


