package com.gemini.client.web;

import com.gemini.domain.Person;
import com.gemini.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author xiaocuzi
 * @package com.gemini.client.web
 * @classname: PersonClientController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/1 16:00
 * @since 1.0.0
 */
@RestController
public class PersonClientController implements PersonService {

    private final PersonService personService;

    @Autowired
    public PersonClientController(PersonService personService) {
        this.personService = personService;
    }


    /**
     * @param person
     * @return
     */
    @Override
    public boolean save(Person person) {
        return personService.save(person);
    }

    /**
     * @return
     */
    @Override
    public Collection<Person> findAll() {
        return personService.findAll();
    }
}
