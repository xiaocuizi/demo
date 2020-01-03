package com.gemini.cache;

import org.apache.commons.lang3.ObjectUtils;
import org.redisson.Redisson;
import org.redisson.core.RLock;

/**
 * @author xiaocuzi
 * @package com.gemini.cache
 * @classname: Redis
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/8/15 17:33
 * @since 1.0.0
 */
public class Redis {

    public synchronized static  int m() {
        System.out.println(Thread.currentThread().getName());
        return 0;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Redis.m();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Redis.m();
            }
        }).start();

        Redis.m();
      /*  Redisson redisson = new Redisson(null);

        RLock rLock = redisson.getLock("name");

        boolean lock = (boolean) rLock.tryLock("name");
*/

    }
}
