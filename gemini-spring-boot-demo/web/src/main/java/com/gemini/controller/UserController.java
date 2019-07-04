package com.gemini.controller;

import com.gemini.entiy.User;
import com.gemini.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.geminispringbootdemo.controller
 * @classname: UserController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/17 18:29
 */
@RestController
@Api(value = "UserController 一个用来测试swagger注解的控制器")
public class UserController {


    private final UserRepository userRepository;


    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     *
     * @param name
     * @return
     */
    @ResponseBody
    @GetMapping("/user/save")
    @ApiOperation(value="根据用户编号获取用户姓名", notes="test: 仅1和2有正确返回")
    @ApiImplicitParam(paramType="query", name = "name", value = "用户姓名", required = true, dataType = "String")
    public User user(@RequestParam  String name){
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user;
    }
    @ResponseBody
    @RequestMapping(value = "/updatePassword",method =RequestMethod.GET)
    @ApiOperation(value="修改用户密码", notes="根据用户id修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userId", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "password", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    public String updatePassword(@RequestParam(value="userId") Integer userId, @RequestParam(value="password") String password,
                                 @RequestParam(value="newPassword") String newPassword){
        if(userId <= 0 || userId > 2){
            return "未知的用户";
        }
        if(StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)){
            return "密码不能为空";
        }
        if(password.equals(newPassword)){
            return "新旧密码不能相同";
        }
        return "密码修改成功!";
    }


}
