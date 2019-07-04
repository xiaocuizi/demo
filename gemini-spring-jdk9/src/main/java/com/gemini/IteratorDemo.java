package com.gemini;


import java.util.Iterator;
import java.util.List;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini
 * @classname: IteratorDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/26 16:22
 */
public class IteratorDemo {

    public static void main(String[] args) {
        List<Integer> values = List.of(1,2,3,4,5);

        Iterator<Integer> integerIterator = values.iterator();
        while (integerIterator.hasNext()){
            Integer next = integerIterator.next();
            System.out.println(next);
        }


    }
}
