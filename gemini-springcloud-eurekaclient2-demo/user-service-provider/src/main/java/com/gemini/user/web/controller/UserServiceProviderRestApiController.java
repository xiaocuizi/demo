package com.gemini.user.web.controller;

import com.gemini.user.domain.User;
import com.gemini.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.user.web.controller
 * @classname: UserServiceProviderRestApiController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/23 18:15
 */
@RestController
public class UserServiceProviderRestApiController {


    @Autowired
    private UserService userService;



    /**
     * @RequestParam org.springframework.web.client.HttpClientErrorException: 400 null
     * @param user
     * @return
     */
    @PostMapping("/user/save")
    public User saveUser(@RequestBody User user) {
        if (userService.save(user)) {
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
        return userService.findAll();
    }
}
