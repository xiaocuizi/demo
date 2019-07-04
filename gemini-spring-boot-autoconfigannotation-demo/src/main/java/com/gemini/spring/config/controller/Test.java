package com.gemini.spring.config.controller;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.spring.config.controller
 * @classname: Test
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/23 21:15
 */
public class Test {
    public static void main(String[] args) {
        int total = 1;
        for (int i = 1; i <11 ; i++) {
            total =total - (total/2+1);
            total = total/2-1;
        }
        System.out.println(total);
    }

    public static void monkey(){
        int total =100;
        int x = (total/2+1);
        monkey();
    }
}


