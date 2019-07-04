package com.gemini.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.geminispringbootdemo.controller
 * @classname: RestDemoController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/15 18:10
 */
public class RestDemoController {

    public String index(){
        return "hello world~";
    }
}
