package com.gemini.nio.buffer;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author xiaocuzi
 * @package com.gemini.nio.buffer
 * @classname: BufferDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/7 10:12
 * @since 1.0.0
 */
public class BufferDemo {

    /**
     *  字节转换成字符
     * @param str
     * @throws UnsupportedEncodingException
     */
    public static void decode(String str) throws UnsupportedEncodingException {
        //分配空间
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        byteBuffer.put(str.getBytes("UTF-8"));
        //翻转，意思可以可以读了e
        byteBuffer.flip();
        //读成字符
        Charset utf8 = Charset.forName("UTF-8");
        CharBuffer charBuffer = utf8.decode(byteBuffer);
        //弄成数组
        char[] chars = Arrays.copyOf(charBuffer.array(), charBuffer.length());
        System.out.println(chars);
    }

    /**
     * 字符 转换成字节
     * @param str
     */
    public static void encode(String str){
        //分配空间
        CharBuffer charBuffer = CharBuffer.allocate(128);
        charBuffer.append(str);
        charBuffer.flip();

        //编码器
        Charset charset = Charset.forName("utf-8");
        ByteBuffer byteBuffer = charset.encode(str);
        byte[] bytes = Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());
        System.out.println(Arrays.toString(bytes));
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        encode("小崔子");
        decode("小崔子");
    }
}
