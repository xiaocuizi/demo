package com.gemini.repository;

import com.gemini.entiy.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.geminispringbootdemo.repository
 * @classname: UserRepository
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/17 14:06
 */
@Repository
public class UserRepository {
    private final ConcurrentMap<Long, User> repostory = new ConcurrentHashMap<>();

    private final AtomicLong iGenerator = new AtomicLong();

    public Boolean save(User user) {
        long id = iGenerator.incrementAndGet();
        user.setId(id);
        return repostory.put(id, user) == null;
    }

    public Collection<User> findAll() {
        return repostory.values();
    }
}
