package com.gemini.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author xiaocuzi
 * @package com.gemini.channel
 * @classname: FileChannelDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/7 10:25
 * @since 1.0.0
 */
public class FileChannelDemo {
    public static void main(String[] args){
        try {
            /**
             * 写文件
             */
            File file = new File("d:/noi_37.data");
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fileOutputStream =  new FileOutputStream(file);
            FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();
            //创建Buffer
            /*创建ByteBuffer对象， position = 0, limit = 64*/
            ByteBuffer byteBuffer = ByteBuffer.allocate(64);
            byteBuffer.put("hello world ->".getBytes("utf-8"));
            byteBuffer.flip();
            /*write方法使得ByteBuffer的position到 limit中的元素写入通道中*/
            fileOutputStreamChannel.write(byteBuffer);
            /*clear方法使得position = 0， limit = 64*/
            byteBuffer.clear();

            byteBuffer.put("这个世界好大，我先去走一走".getBytes("utf-8"));
            byteBuffer.flip();
            fileOutputStreamChannel.write(byteBuffer);
            byteBuffer.clear();
            //关闭
            fileOutputStream.close();
            fileOutputStreamChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        /**
         * 读文件
          */
        //获取路径
        Path path = Paths.get("d:/noi_37.data");
        //获得channerl
        try {
            FileChannel fileChannel = FileChannel.open(path);
            //读到Buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) (fileChannel.size()+1));
            int read = fileChannel.read(byteBuffer);
            byteBuffer.flip();
            Charset charset = Charset.forName("utf-8");
            CharBuffer charBuffer = charset.decode(byteBuffer);
            System.out.println("============================");
            System.out.println(charBuffer.toString());
            byteBuffer.clear();
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
