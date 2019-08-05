package com.gemini.core;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: User
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/13 20:53
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}




