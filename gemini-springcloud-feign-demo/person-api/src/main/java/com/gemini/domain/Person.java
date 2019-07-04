package com.gemini.domain;

/**
 * @author xiaocuzi
 * @package com.gemini.domain
 * @classname: Person
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/1 15:48
 * @since 1.0.0
 */
public class Person {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
