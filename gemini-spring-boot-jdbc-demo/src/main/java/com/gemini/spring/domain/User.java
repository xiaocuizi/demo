package com.gemini.spring.domain;

import java.util.Random;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring
 * @classname: User
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/21 21:16
 */
public class User {

    private int id;
    private String name;
    private int age = new Random().nextInt(20);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
