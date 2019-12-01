package com.gemini.geminispringbootauthserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author xiaocuzi
 * @package com.gemini.geminispringbootauthserver
 * @classname: WelcomeController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/9/28 10:37
 * @since 1.0.0
 */
@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/hello")
    public String user(String user) {
        return "welcome";
    }
}
