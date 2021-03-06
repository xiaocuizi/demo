package com.gemini.web;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaocuzi
 * @package com.gemini.web
 * @classname: DemoController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/5 16:11
 * @since 1.0.0
 */
@RestController
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    /**
     *
     * @return
     */
    @GetMapping("")
    public String index(){
        String reValue = "Hello Words";
        logger.info("{},index ():{}",getClass().getSimpleName(),reValue);
        return reValue;
    }


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/to/zuul/person-client/person/find/all")
    public Object toZuul() {
        logger.info("spring-cloud-sleuth#toZuul()");
        // spring-cloud-zuul :  7070
        String url = "http://spring-cloud-zuul/person-client/person/find/all";
        return restTemplate.getForObject(
                url, Object.class);
    }
}
