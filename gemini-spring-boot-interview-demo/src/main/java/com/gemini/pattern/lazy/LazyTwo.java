package com.gemini.pattern.lazy;

public class LazyTwo {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<LazyTwo> lazyTwoClass = LazyTwo.class;
        Class<?> aClass = Class.forName("com.gemini.pattern.lazy.LazyTwo");
        //this.getClass().getClassLoader().get
    }
    private static  LazyTwo lazyTwo= null;


    public static synchronized LazyTwo getInstance(){

        if(lazyTwo ==null){
            lazyTwo = new LazyTwo();
        }
        return lazyTwo;
    }
}
