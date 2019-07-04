package com.gemini.web.ormframwork;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.orm
 * @classname: TestA
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/24 20:24
 */
public class TestA {

    static volatile LinkedList linkedList = new LinkedList();
    static Random random = new Random(1000);

    public static void main(String[] args) {
       /* Map map = new HashMap<>();
        map.put("1", "java");
        int hashCode = "java".hashCode();
        System.out.println((hashCode % 15));
        System.out.println((15 & hashCode));
        int[] a = {1,5,3,7,9,2,4};
        Arrays.parallelSort(a);
        System.out.println(Arrays.toString(a));*/
        new Thread(() -> {
            while (true){
                linkedList.add(random.nextInt());
                System.out.println("添加元素成功。。。");
                /*try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        })/*.start()*/;

        new Thread(() -> {
            while (true){
                System.out.println(linkedList.getFirst());
                System.out.println("==============");
            }
        })/*.start()*/;



    }
    //ORM(对象关系映射，Object relation Mapping )

    /**
     * Hibernate mybatis JPA SpringJDBC
     * Hibernate 全自动的
     * MyBatis 手自一体（半自动）
     * Spring 手动挡，包括SQL语句，映射都是需要自己实现的（最省油）
     *
     *
     *
     *
     * //TODO
     * 1、统一方法名
     * 2、统一参数
     * 3、统一返回结果
     */
}
