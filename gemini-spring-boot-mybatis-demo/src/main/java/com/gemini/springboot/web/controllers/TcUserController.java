package com.gemini.springboot.web.controllers;

import com.gemini.springboot.web.entity.TcUser;
import com.gemini.springboot.web.service.TcUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Description: TcUserController <br>
 *
 * Do not edit this file
 * It was auto-generated by Code-Generator
 *
 * @since 2019-1-6 22:23:31
 */
@Controller
@RequestMapping("/")
public class TcUserController {

    private static final String SUCCESS = "SUCCESS";

    @Resource
    private TcUserService tcUserService;

    public String init() {
        return null;
    }

    public String save(TcUser tcUser) {
        tcUserService.save(tcUser);
        return SUCCESS;
    }

    public String update(TcUser tcUser) {
        tcUserService.update(tcUser);
        return SUCCESS;
    }

    public String delete(Integer id) {
        tcUserService.delete(id);
        return SUCCESS;
    }

    public String queryById(Integer id) {
        tcUserService.queryById(id);
        return SUCCESS;
    }
}