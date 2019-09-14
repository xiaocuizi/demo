package com.gemini.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaocuzi
 * @package com.gemini.controller
 * @classname: HelloController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/14 23:09
 * @since 1.0.0
 */
@RestController
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger( HelloController.class );

    @Value("${server.port}")
    String port;
    @Value("${key1}")
    String key1;

    @GetMapping("hi")
    public String hi(String name) {

        logger.debug( "debug log..." );
        logger.info( "info log..." );
        logger.warn( "warn log..." );

        return "hi " + name + " ,i am from port:" + port +",key:"+key1;
    }
}
