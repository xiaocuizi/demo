package com.gemini.user.web.repository;

import com.gemini.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.user.web.repository
 * @classname: UserRepository
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/23 18:18
 */
@Repository
public class UserRepository {

    private ConcurrentMap<Long,User> userRepository = new ConcurrentHashMap<Long,User>();

    private static final AtomicLong idGeraltor = new AtomicLong(0);

    public Collection<User> findAll(){
        return userRepository.values();
    }


    /**
     *
     * @param user
     * @return
     */
    public boolean saveUser(User user) {
        long id = idGeraltor.incrementAndGet();
        user.setId(id);
        return userRepository.putIfAbsent(id, user) == null;
    }


}
