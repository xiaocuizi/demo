package com.gemini.core.base.collections;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.base.collections
 * @classname: TreeSetDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/13 21:23
 */
public class TreeSetDemo {

    public static void main(String[] args) {
//        TreeMap treeMap = new TreeMap();
//        treeMap.put("key",2);
//        treeMap.put("key3",3);
//        System.out.println(treeMap.get("key"));
//        System.out.println(treeMap.get(""));
        TreeSet treeSet = new TreeSet();
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(7);
        boolean hasNext = treeSet.iterator().hasNext();
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


