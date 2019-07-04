package com.gemini.domain.entity;


import javax.persistence.*;

/**
 * @author xiaocuzi
 * @package com.gemini.domain.entity
 * @classname: Person
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/6 10:23
 * @since 1.0.0
 */
@Entity
@Table(name = "tc_persons")
public class Person extends com.gemini.domain.Person{

    @Override
    @Id
    @GeneratedValue
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    @Column
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
    /*@Id
    @GeneratedValue//TODO 这个设置，程序在运行的时候会出错，因为表里面已经生成ID了,id不传就可以了
    private Long id;
    @Column
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
    }*/
}









