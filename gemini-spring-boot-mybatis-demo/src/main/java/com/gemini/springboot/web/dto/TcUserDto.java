package com.gemini.springboot.web.dto;

import java.io.Serializable;

/**
 * Description:     TcUserDto <br>
 *
 * Do not edit this file
 * It was auto-generated by Code-Generator
 *
 * @since 2019-1-6 22:23:32
 */
public class TcUserDto implements Serializable {

    /**	 *表主键	 */
    private Integer id;

    private String name;

    private Integer age;


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}