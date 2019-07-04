package com.gemini.domain.service;

import com.gemini.domain.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @author xiaocuzi
 * @package com.gemini.domain.service
 * @classname: PersonService
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/1 15:49
 * @since 1.0.0
 */
//todo @FeignClient(value = "person-service",fallback = PersonServiceFallback.class)
@FeignClient(value = "person-service")
public interface PersonService {
    /**
     *
     * @param person
     * @return
     */
    @PostMapping("/person/save")
    boolean save(Person person);

    /**
     *
     * @return
     */
    @GetMapping("/person/find/all")
    Collection<Person> findAll();
}
