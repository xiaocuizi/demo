package com.gemini.pserson.service.provider.service;

import com.gemini.domain.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author xiaocuzi
 * @package com.gemini.pserson.service.provider.service
 * @classname: PersonService
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/6 10:30
 * @since 1.0.0
 */
@Service
@Transactional
public class PersonService {

    /**
     * 通过标准JPA的方式及注入
     */
    @PersistenceContext

    private EntityManager entityManager;

    //@Transactional(Transactional.TxType.REQUIRED)
    public void save(Person person){
        entityManager.persist(person);
    }
}
