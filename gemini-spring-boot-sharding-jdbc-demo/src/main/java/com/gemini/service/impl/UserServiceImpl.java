package com.gemini.service.impl;


import com.gemini.entity.User;
import com.gemini.repository.UserRepository;
import com.gemini.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public Integer addUser(User user) {

        // 强制路由主库
        //HintManager.getInstance().setMasterRouteOnly();
        return userRepository.addUser(user);
    }

    @Override
    public List<User> list() {

        return userRepository.list();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
