package com.gemini.pserson.service.provider.repository;

import com.gemini.domain.entity.Person;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author xiaocuzi
 * @package com.gemini.pserson.service.provider.repository
 * @classname: PersonRepository
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/6 15:33
 * @since 1.0.0
 */
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person,Long> {//Person,Long 这个两个必须的
}