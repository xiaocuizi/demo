package com.gemini.bio;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xiaocuzi
 * @package com.gemini.bio
 * @classname: TestBio
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/3 17:55
 * @since 1.0.0
 */
public class TestBio {
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            try {
                Server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(5000);
        System.out.printf("--------------------------");

        //String op = "+-*/";
        char[] op = {'+','-','*','/'};
        //ThreadLocalRandom random
        Random random = new Random(System.currentTimeMillis());
        new Thread(()->{
            while (true){
                String expression = random.nextInt(10) + "" + op[random.nextInt(4)]+(random.nextInt(10) + 1);
                Client.send(expression);
            }
        }).start();
    }
}
