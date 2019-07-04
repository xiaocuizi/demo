package com.gemini.user.web.service;

import com.gemini.user.domain.User;
import com.gemini.user.service.UserService;
import com.gemini.user.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.user.web.service
 * @classname: UserServiceImpl
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/23 18:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    /**
     * 成功tr
     *
     * @param user
     * @return
     */
    @Override
    public boolean save(User user) {
        return repository.saveUser(user);
    }

    /**
     * 不会返回NULL
     *
     * @return
     */
    @Override
    public Collection<User> findAll() {
        return repository.findAll();
    }
}
