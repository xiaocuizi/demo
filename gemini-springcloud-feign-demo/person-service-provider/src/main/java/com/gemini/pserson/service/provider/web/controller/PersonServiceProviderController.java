package com.gemini.pserson.service.provider.web.controller;

import com.gemini.domain.Person;
import com.gemini.pserson.service.provider.repository.PersonRepository;
import com.gemini.pserson.service.provider.service.PersonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaocuzi
 * @package com.gemini.pserson.service.provider.web.controller
 * @classname: PersonServiceProviderController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/1 16:16
 * @since 1.0.0
 */
@RestController
public class PersonServiceProviderController {

    private Map persons = new ConcurrentHashMap<Long,Person>();

    private static Random random = new Random();


    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    /**
     * @param person
     * @return
     */
    @PostMapping("/person/save")
    public boolean savePerson(@RequestBody Person person) {
      // return persons.put(person.getId(),person)==null;
        //personService.save();
        com.gemini.domain.entity.Person person1 = new com.gemini.domain.entity.Person();
        BeanUtils.copyProperties(person,person1);
        //personService.save(person1);
        personRepository.save(person1);
       return true;
    }

    /**
     *
     * @return
     */
    @GetMapping("/person/find/all" )
    @HystrixCommand(fallbackMethod="fallbackForFindAllPersons",
            commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1000")})
    public Collection<Person> findAll() throws InterruptedException {
        int nextInt = random.nextInt(200);
        System.out.printf("nextInt=%s",nextInt);
        //Thread.sleep(nextInt);
        return persons.values();
    }

    public Collection<Person> fallbackForFindAllPersons(){
        System.out.println("fallbackForFindAllPersons 超时调用");
        return Collections.emptyList();
    }


    /**
     * @param pageable
     * @return
     */
    @GetMapping("/person/list")
    public Page<com.gemini.domain.entity.Person> list(Pageable pageable) {
        return personRepository.findAll(pageable);
    }
}
