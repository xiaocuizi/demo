package com.gemini.buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/7 20:39
 */
public class MappedByteBufferTest {
    public static final String SOURCE_PATH = "E:\\RocketMQ\\data\\rocketmq\\dataDir\\commitlog\\00000000001073741824";
    public static final String DEST_PATH = "D:\\downloads\\demo (1)\\00000000001073741824_____f";
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        //        test1();
        test2();
        /**
         * test1():结束.....................
         * cost time:11403
         * test2():结束.....................
         * cost time:5134
         * test1():结束.....................
         * cost time:10963
         * test2():结束.....................
         * cost time:3711
         */
        System.out.printf("cost time:%s%n", (System.currentTimeMillis() - start));
    }

    // 直接缓冲区
    private static void test2() {
        System.out.printf("test2():%s%n", "开始.....................");
        // 打开通道
        try {
            final FileChannel inChannel = FileChannel.open(Paths.get(SOURCE_PATH), StandardOpenOption.READ);
            final FileChannel outChannel =
                    FileChannel.open(Paths.get(DEST_PATH),
                            StandardOpenOption.WRITE,
                            StandardOpenOption.READ,
                            // CREATE，如果目标文件存在就覆盖
                            // CREATE_NEW抛异常
                            StandardOpenOption.CREATE);
            // 获取内存映射文件
            MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            // 直接对缓冲区进行数据的读写操作
            byte[] dst = new byte[inMappedByteBuffer.limit()];
            inMappedByteBuffer.get(dst);
            outMappedByteBuffer.put(dst);

            inChannel.close();
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("test2():%s%n", "结束.....................");
        }


    }

    private static void test1() throws IOException {
        System.out.printf("test1():%s%n", "开始.....................");
        FileInputStream fileInputStream = new FileInputStream(SOURCE_PATH);
        FileOutputStream fileOutputStream = new FileOutputStream(DEST_PATH);
        // 获取通道
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            while (fileInputStreamChannel.read(buffer) != -1) {
                // 切换读模式
                buffer.flip();
                fileOutputStreamChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileOutputStreamChannel.close();
            fileInputStreamChannel.close();
            fileOutputStream.close();
            fileInputStream.close();
            System.out.printf("test1():%s%n", "结束.....................");
        }
    }
}
