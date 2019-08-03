package com.gemini.lambda;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaocuzi
 * @package com.gemini.lambda
 * @classname: Test1
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/7/28 11:12
 * @since 1.0.0
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(getTotalCoin());
    }

    /**
     * 获取总数
     *
     * @return
     */
    private static Long getTotalCoin() {
        ArrayList<Person> personList = Lists.newArrayList();
        personList.add(new Person(1, "张三", 23L));
        personList.add(new Person(2, "李四", 12L));
        personList.add(new Person(3, "王五", 20L));
        personList.add(new Person(3, "小六", 73L));
        // 这里求和
        return personList.stream().mapToLong(person -> person.getIncomeCoin()).sum();
    }
    public static class Person{
        /** id */
        private int id;
        /** 姓名*/
        private String name;
        /** 收入金币数*/
        private Long incomeCoin;

        public Person(int id, String name, Long incomeCoin) {
            this.id = id;
            this.name = name;
            this.incomeCoin = incomeCoin;
        }

        public Long getIncomeCoin() {
            return incomeCoin;
        }
    }
}
