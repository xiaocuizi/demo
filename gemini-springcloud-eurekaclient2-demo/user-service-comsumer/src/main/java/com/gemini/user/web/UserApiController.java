package com.gemini.user.web;

import com.gemini.user.domain.User;
import com.gemini.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.user.web
 * @classname: UserController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/23 18:05
 */
@RestController
public class UserApiController {

    @Autowired
    private UserService service;


    /**
     *
     * @param name
     * @return
     */
    @GetMapping("/user/save")
    public User saveUser(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        if (service.save(user)) {
            return user;
        }
        return null;
    }


    /**
     *
     * @return
     */
    @GetMapping("/user/list")
    public Collection<User> list() {
        return service.findAll();
    }
}
