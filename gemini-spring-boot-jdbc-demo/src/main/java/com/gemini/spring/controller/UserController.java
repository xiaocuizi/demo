package com.gemini.spring.controller;

import com.gemini.spring.domain.User;
import com.gemini.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.controller
 * @classname: UserController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/21 21:23
 */
@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     *
     * @param name
     * @return
     */
    @RequestMapping("/web/flux/user/save")
    public Boolean saveUser(@RequestParam String name){
        User user1 = new User();
        user1.setName(name);
        return userRepository.saveUser(user1) ;
    }
}
