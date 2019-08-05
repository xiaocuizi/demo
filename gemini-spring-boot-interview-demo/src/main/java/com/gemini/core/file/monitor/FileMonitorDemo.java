package com.gemini.core.file.monitor;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.file.monitor
 * @classname: FileMonitorDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/24 21:23
 */
public class FileMonitorDemo {


    /**
     * WinNTFileSystem.java
     * Windows NT/2000    new Tentachloyt
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        File userDir = new File("");
        println("用户目录："+System.getProperty("user.home"));
        println("用户工作目录："+System.getProperty("user.dir"));
        println("用户工作目录："+userDir.getAbsolutePath());

        File userDir2 = new File(System.getProperty("user.dir"));
        long lastModified = userDir2.lastModified();
        List<String> subFies = toList(userDir2.list());
        while (true){
            Thread.sleep(2000);
            if(lastModified ==userDir2.lastModified()){
                System.out.println("最后更新时间没有变化，继续....");
                continue;
            }
            List<String> remainSubFiles = toList(userDir2.list());
            remainSubFiles.removeAll(subFies);//剩余文件
            Stream.of(remainSubFiles).forEach(value->{
                println("新增的文件："+value);
            });
            lastModified =userDir2.lastModified();
            subFies = remainSubFiles;
        }

    }
    //用户目录  。用户工作目录

    private static void println(Object object){
        System.out.println(object);
    }

    private static <T> List<T> toList(T... valuse){
        return new ArrayList<>(Arrays.asList(valuse));
    }
}


