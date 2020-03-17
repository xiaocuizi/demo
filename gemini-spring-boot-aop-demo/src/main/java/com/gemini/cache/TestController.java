package com.gemini.cache;

import com.gemini.Result;
import com.gemini.log.DoSomething;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Date: 2019/3/26 17:03
 * @Version 1.0
 */


@RestController
public class TestController {
    @Resource
    private UserDao userDao;

    // 1. 要校验的参数前，加上@Valid注解
    // 2. 紧随其后的，跟上一个BindingResult来存储校验信息
    @RequestMapping("/test1")
    public Object test1(@Valid User user, BindingResult bindingResult) {
        //如果检验出了问题，就返回错误信息
        // 这里我们返回的是全部的错误信息，实际中可根据bindingResult的方法根据需要返回自定义的信息。
        // 通常的解决方案为：JSR-303 + 全局ExceptionHandler
//        if (bindingResult.hasErrors()) {
//            return bindingResult.getAllErrors();
//        }
        Result okResult = new Result();
        okResult.setCode(200);
        okResult.setMessage(user.toString());
        return okResult;
    }

    /**
     * 查询出一条数据并且添加到缓存
     *
     * @param userId
     * @return
     */
    @RequestMapping("/getUser")
//    @Cacheable("userCache")
    @DoSomething(key = "user", val = "sdsd", exTime = 3)
    public User getPrud(@RequestParam(required = true) String userId) {
        System.out.println("如果没有缓存，就会调用下面方法，如果有缓存，则直接输出，不会输出此段话");
        return userDao.getUser(Integer.parseInt(userId));
    }

    /**
     * 删除一个缓存
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteUser")
    @CacheEvict("userCache")
    public String deleteUser(@RequestParam(required = true) String userId) {
        return "删除成功";
    }

    /**
     * 添加一条保存的数据到缓存，缓存的key是当前user的id
     *
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    @CachePut(value = "userCache", key = "#result.userId +''")
    public User saveUser(User user) {
        return user;
    }


    /**
     * 返回结果userPassword中含有nocache字符串就不缓存
     *
     * @param userId
     * @return
     */
    @RequestMapping("/getUser2")
    @CachePut(value = "userCache", unless = "#result.userPassword.contains('nocache')")
    public User getUser2(@RequestParam(required = true) String userId) {
        System.out.println("如果走到这里说明，说明缓存没有生效！");
        User user = new User(Integer.parseInt(userId), "name_nocache" + userId, "nocache");
        return user;
    }


    @RequestMapping("/getUser3")
    @Cacheable(value = "userCache", key = "#root.targetClass.getName() + #root.methodName + #userId")
    public User getUser3(@RequestParam(required = true) String userId) {
        System.out.println("如果第二次没有走到这里说明缓存被添加了");
        return userDao.getUser(Integer.parseInt(userId));
    }
}

