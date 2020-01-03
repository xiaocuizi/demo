package com.gemini.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @author xiaocuzi
 * @package com.gemini.gc
 * @classname: Main
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/12/12 10:40
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
       /* List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean b : list) {
            System.out.println(b.getName());
        }*/
        long start = System.currentTimeMillis();
        for (int i = 0; i < 4000; i++) {
           // int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                  //  System.out.println(finalI);
                }
            }).start();
        }
        System.out.println("===="+(System.currentTimeMillis() - start));
    }
}
