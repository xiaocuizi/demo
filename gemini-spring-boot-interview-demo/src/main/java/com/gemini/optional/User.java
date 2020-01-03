package com.gemini.optional;

/**
 * @author xiaocuzi
 * @package com.gemini.optional
 * @classname: User
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/12/7 18:03
 * @since 1.0.0
 */
public class User {
    private Integer id;
    private String name;


    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
