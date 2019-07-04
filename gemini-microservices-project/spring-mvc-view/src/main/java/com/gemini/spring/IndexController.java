package com.gemini.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemni.spring.mvc
 * @classname: IndexController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/14 15:31
 */
@Controller
public class IndexController {


    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("message","helloWorld");
        return "index";
    }

}
