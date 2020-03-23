package com.gemini.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gemini.shop.service.IUerInterface;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.controller
 * @classname: UserController
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/23 10:48
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private IUerInterface userService;

    @RequestMapping("/sayHello")
    public String sayHello(String name){
        return userService.sayHello(name);
    }

}
