package com.gemini.core;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core
 * @classname: AtomicStampedReferenceDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/24 10:25
 */
public class AtomicStampedReferenceDemo {
    static AtomicReference<Integer> money = new AtomicReference<Integer>();

    public static void main(String[] args) throws IOException {
        money.set(19);
        Integer money3 = money.get();
        boolean b;
        if (money.compareAndSet(money3, money3 + 1)) {
            b = true;
        } else {
            b = false;
        }
        System.out.println(b + "<=opopo");

        System.out.println(new AtomicStampedReferenceDemo().getClass().getClassLoader().getParent().getParent());
        System.out.println(new AtomicStampedReferenceDemo().getClass().getClassLoader().getParent());
        System.out.println(new AtomicStampedReferenceDemo().getClass().getClassLoader());

    }
}


