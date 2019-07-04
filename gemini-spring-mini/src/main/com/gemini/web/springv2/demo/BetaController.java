package com.gemini.web.springv2.demo;

import com.gemini.web.springv2.annotation.GMAutoWried;
import com.gemini.web.springv2.annotation.GMController;
import com.gemini.web.springv2.annotation.GMRequestMapping;
import com.gemini.web.springv2.annotation.GMRequestParam;
import com.gemini.web.springv2.webmvc.servlet.GMModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
    public GMModelAndView say() {
        betaService.say("tomcat");
        return null ;
    }

    @GMRequestMapping("/hello")
    public GMModelAndView hello(@GMRequestParam("name") String name, String subject) {
        betaService.say("tomcat");
        Map<String, Object> model = new HashMap<String, Object>();
        if (name == null) {
            model.put("name", "xiaocuiz9");
        } else {
            model.put("name", name);
        }
        if (subject == null) {
            model.put("subject", "spring");
        } else {
            model.put("subject", subject);
        }
        GMModelAndView gmModelAndView = new GMModelAndView("first.html", model);
        return gmModelAndView;
    }
}
