package com.gemni.geminispringbootsentineldemo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaocuzi
 * @package com.gemni.geminispringbootsentineldemo.controller
 * @classname: HelloController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/12/29 13:27
 * @since 1.0.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    @SentinelResource("helloworld")
    public String hello(){
        return "hello";
    }
}
