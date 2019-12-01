package com.gemini.arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiaocuzi
 * @package com.gemini.arithmetic
 * @classname: ArrayListDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/9/26 20:14
 * @since 1.0.0
 */
public class ArrayListDemo {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (Integer i : list) {
            if (i == 3) {
                list.add(12);
            }
        }
//        int incr = incr();
//        System.out.printf("incr=%s",incr);

    }

    public static int incr() {
        int x;
        try {
            x = 1 / 0;
            return x;
        } catch (Exception e) {

            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
