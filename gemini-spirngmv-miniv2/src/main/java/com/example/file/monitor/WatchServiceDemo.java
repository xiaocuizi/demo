package com.example.file.monitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.example.file.monitor
 * @classname: WatchServiceDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/3/24 22:44
 */
public class WatchServiceDemo {
    public static void main(String[] args) {
        try {
            //获取监听服务
            WatchService watchService = FileSystems.getDefault().newWatchService();
            //文件对象
            //File userDir2 = new File(System.getProperty("user.dir"));
            //  WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
            String dir  = System.getProperty("user.dir");
            Path path = FileSystems.getDefault().getPath(dir);
            /*FileSystems.getDefault().getPath(System.getProperty("user.dir"),System.getProperty("user.dir"));
            Path path = userDir2.toPath();*/

            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.OVERFLOW);
            //todo 注册子目录
            File file = new File(dir);
            LinkedList<File> fList = new LinkedList<File>();
            fList.addLast(file);
            while (fList.size() > 0) {
                File f = fList.removeFirst();
                if (f.listFiles() == null) {
                    continue;
                }
                for (File file2 : f.listFiles()) {
                    if (file2.isDirectory()) {//下一级目录
                        fList.addLast(file2);
                        //依次注册子目录
                        Paths.get(file2.getAbsolutePath()).register(watchService
                                , StandardWatchEventKinds.ENTRY_CREATE
                                , StandardWatchEventKinds.ENTRY_MODIFY
                                , StandardWatchEventKinds.ENTRY_DELETE
                                , StandardWatchEventKinds.OVERFLOW);
                    }
                }
            }



            while (true){
               // Thread.sleep(2000);
                WatchKey watchKey = watchService.poll();
                if(watchKey ==null){
                    //System.out.println("事件不存在。。。");
                    continue;
                }
                List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
                for (WatchEvent<?> event:watchEvents) {
                    System.out.println("StandardWatchEventKinds.ENTRY_CREATE.name()=="+StandardWatchEventKinds.ENTRY_CREATE.name());
                    System.out.println("event.kind().name()=="+event.kind().name());
                    if(StandardWatchEventKinds.ENTRY_CREATE.name().equals(event.kind().name())) {
                        Path subPath = (Path) event.context();
                        System.out.println("新建文件：" + subPath);
                    }else if(StandardWatchEventKinds.ENTRY_MODIFY.name().equals(event.kind().name())){
                        Path subPath = (Path) event.context();
                        System.out.println("修改文件：" + subPath);
                    }else if(StandardWatchEventKinds.ENTRY_DELETE.name().equals(event.kind().name())){
                        Path subPath = (Path) event.context();
                        System.out.println("删除文件：" + subPath);
                    }else if(StandardWatchEventKinds.OVERFLOW.name().equals(event.kind().name())){
                        Path subPath = (Path) event.context();
                        System.out.println("OVERFLOW文件：" + subPath);
                    }
                    boolean reset = watchKey.reset();
                    if(!reset){break;}
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


