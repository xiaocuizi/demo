package com.gemini.user.service;

import com.gemini.user.domain.User;

import java.util.Collection;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.user.service
 * @classname: UserService
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/23 18:02
 */
public interface UserService {
    /**
     * 成功tr
     * @param user
     * @return
     */
    boolean save(User user);

    /**
     * 不会返回NULL
     * @return
     */
    Collection<User> findAll();
}
