package com.gemini.drivenannotation;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.drivenannotation
 * @classname: User
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/22 19:55
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}


