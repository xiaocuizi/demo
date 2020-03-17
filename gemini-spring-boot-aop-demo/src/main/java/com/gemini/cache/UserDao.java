package com.gemini.cache;

import org.springframework.stereotype.Service;

/**
 * @Version 1.0
 */
@Service
public class UserDao {

    public User getUser(int userId) {
        System.out.println("执行此方法，说明没有缓存，如果没有走到这里，就说明缓存成功了");
        User user = new User(userId, "没有缓存_"+userId, "password_"+userId);
        return user;
    }

    public User getUser2(int userId) {
        System.out.println("执行此方法，说明没有缓存，如果没有走到这里，就说明缓存成功了");
        User user = new User(userId, "name_nocache"+userId, "nocache");
        return user;
    }
}
