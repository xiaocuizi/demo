package com.gemini.core.base.collections;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.base.collections
 * @classname: Student
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/14 10:52
 */
public class Student {

    public static void main(String[] args) {
        String s = "123";
        String s2 = "123";
        String s3 = new String("123");

        System.out.println(s == s2);
        System.out.println(s.equals(s2));
        System.out.println(s == (s3));
    }

    private String name;    // 姓名
    private int age;        // 年龄

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


