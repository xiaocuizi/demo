package com.gemini.web.springv1.demo;

import com.gemini.web.springv1.annotation.GMAutoWried;
import com.gemini.web.springv1.annotation.GMController;
import com.gemini.web.springv1.annotation.GMRequestMapping;

import javax.annotation.Resource;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv1.demo
 * @classname: BetaController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/16 14:58
 */
@GMController
@GMRequestMapping("/index")
public class BetaController {

    @GMAutoWried
    private BetaService betaService;

    @GMRequestMapping("/say")
    public String say() {
        betaService.say("tomcat");
        return "";
    }
}
