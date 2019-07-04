package com.gemini.client.hystrix;

import com.gemini.domain.Person;
import com.gemini.domain.service.PersonService;

import java.util.Collection;

/**
 * @author xiaocuzi
 * @package com.gemini.client.hystrix
 * @classname: PersonServiceFallback
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/2 16:53
 * @since 1.0.0
 */
public class PersonServiceFallback implements PersonService {
    /**
     * @param person
     * @return
     */
    @Override
    public boolean save(Person person) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public Collection<Person> findAll() {
        return null;
    }
}
