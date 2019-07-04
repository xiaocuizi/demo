package com.gemini.springboot.web.iocDemo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiaocuzi
 * @package com.gemini.springboot.web.iocDemo
 * @classname: IocDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/29 15:49
 * @since 1.0.0
 */
public class IocDemo {
    private String name;
    private Integer age;

    public IocDemo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
