package com.gemini.pattern.lazy;

public class LazyThreeTest {


    public static void main(String[] args) {
        Thread thread1 = new Thread(
                () -> {
                    LazyThree.getInstance();
                }
        );
        Thread thread = new Thread(() -> {
            LazyThree.getInstance();
        });
        thread1.start();
        thread.start();;
        System.out.println("end .................");
    }
}
