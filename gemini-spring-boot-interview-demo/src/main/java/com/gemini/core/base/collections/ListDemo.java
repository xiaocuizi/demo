package com.gemini.core.base.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.base.collections
 * @classname: ListDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/14 10:51
 */
public class ListDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        list.add(new Student("Hao LUO", 33));
        list.add(new Student("XJ WANG", 32));
        list.add(new Student("Bruce LEE", 60));
        list.add(new Student("Bob YANG", 22));
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //return o1.getName().compareTo(o2.getName());
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
}


