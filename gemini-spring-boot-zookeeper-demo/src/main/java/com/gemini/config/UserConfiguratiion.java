package com.gemini.config;

import com.gemini.drivenannotation.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.config
 * @classname: UserConfiguratiion
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/23 10:39
 */
@Configuration
public class UserConfiguratiion {

    @Bean(name = "user")
    public User user(){
        User user = new User();
        user.setName("xiaomage");
        return user;
    }
}


