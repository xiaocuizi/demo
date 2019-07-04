package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaocuzi
 * @package com.example
 * @classname: Controller
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/6/2 17:45
 * @since 1.0.0
 */
@RestController
public class Controller {


    @GetMapping("/index")
    public String index() {
        return "hello";
    }
}
