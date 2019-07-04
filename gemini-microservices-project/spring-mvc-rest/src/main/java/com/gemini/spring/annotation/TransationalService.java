package com.gemini.spring.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.annotation
 * @classname: TransationalService
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/18 16:58
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@Service
@Transactional
public @interface TransationalService {

    /**
     *
     * @return
     */
    @AliasFor(annotation = Service.class,attribute = "value")
    String value() ;
}
