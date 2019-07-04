package com.gemini.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.controller
 * @classname: EchoController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/23 11:00
 */
@RestController
@RefreshScope
public class EchoController {

    @Value("${my.name}")
    private String myName;

    @RequestMapping("/my-name")
    public String getMyName(){
        return myName;
    }
}
