package com.gemini.web.springv1.demo;

import com.gemini.web.springv1.annotation.GMService;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv1.demo
 * @classname: BetaServiceImpl
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/16 14:58
 */
@GMService
public class BetaServiceImpl implements BetaService{
    /**
     * say hi
     *
     * @param name
     * @return
     */
    public String say(String name) {
        System.out.println("I am "+name);
        return "I am "+name;
    }
}
