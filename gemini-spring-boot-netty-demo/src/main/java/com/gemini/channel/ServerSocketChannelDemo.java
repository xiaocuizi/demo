package com.gemini.channel;

import com.gemini.buffer.Buffers;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xiaocuzi
 * @package com.gemini.channel
 * @classname: ServerSocketChannelDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/7 15:16
 * @since 1.0.0
 */
public class ServerSocketChannelDemo {




    /**
     * 服务端
     */
    public static class TCPEchoServer implements Runnable{
        //端口地址
        private InetSocketAddress inetSocketAddress;

        public TCPEchoServer(int port) {
            this.inetSocketAddress = new InetSocketAddress(port);
            System.out.println("绑定端口成功。addreess="+inetSocketAddress);
        }

        @Override
        public void run() {
            Charset utf8 = Charset.forName("UTF-8");
            Selector selector = null;
            ServerSocketChannel serverSocketChannel =null;
            try {
                //创建seletor
                selector = Selector.open();
                //创建channel
                serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.bind(inetSocketAddress, 100);
                //selector与chanel绑定关系
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                System.out.println("selector与chanel绑定成功。addreess="+inetSocketAddress);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("端口注册异常");
                return;
            }

            //接收客户端请求
            System.out.println("server start addreess="+ inetSocketAddress);
            SelectionKey selectionKey = null;
            try {
                while (!Thread.currentThread().isInterrupted()){
                    int i = selector.select();
                    if(i ==0){
                        continue;
                    }
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
                    while (keyIterator.hasNext()){
                        selectionKey = keyIterator.next();
                        /* todo 防止下次select方法返回已处理过的通道*/
                        keyIterator.remove();
                        //如果key是可接收状态   /*ssc通道只能对链接事件感兴趣*/
                        if(selectionKey.isAcceptable()){
                            //一个Key ,对应一个channel
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            /* todo 向选择器注册这个通道和普通通道感兴趣的事件，同时提供这个新通道相关的缓冲区*/
                            socketChannel.register(selector, SelectionKey.OP_READ, new Buffers(256,256));
                            System.out.println("接收到客户端请求 from "+socketChannel.getRemoteAddress());
                        }

                        /**
                         * 有可读事件  就读取附件
                         */
                        if(selectionKey.isReadable()){
                            Buffers buffers = (Buffers) selectionKey.attachment();
                            ByteBuffer readBuffer = buffers.getReadBuffer();
                            ByteBuffer writeBuffer = buffers.getWriteBuffer();
                            //获取通道，读取数据到缓冲
                            SocketChannel channel = (SocketChannel) selectionKey.channel();
                            channel.read(readBuffer);
                            readBuffer.flip();
                            /*解码显示，客户端发送来的信息  //TODO 这里可能需要开发的时候的业务处*/
                            CharBuffer charBuffer = utf8.decode(readBuffer);
                            System.out.println("客户端来的消息："+ charBuffer.toString());
                            //todo 这里写消息返回给客户端
                            readBuffer.rewind();

                            writeBuffer.put("echo from server".getBytes("UTF-8"));
                            writeBuffer.put(readBuffer);

                            readBuffer.clear();

                            //设置通道写事件

                            selectionKey.interestOps(selectionKey.interestOps() | SelectionKey.OP_WRITE);

                        }
                        /* todo 通道感兴趣写事件且底层缓冲区有空闲*/

                        if(selectionKey.isWritable()){
                            System.out.println("开始写消息->....");
                            Buffers buffers = (Buffers)selectionKey.attachment();
                            ByteBuffer writeBuffer = buffers.getWriteBuffer();
                            //Buffer从写模式切换到读模式
                            writeBuffer.flip();
                            //TODO 获取通道
                            SocketChannel channel = (SocketChannel) selectionKey.channel();
                            //TODO 表示当前位置和极限之间是否有任何元素。也就是还有写空间
                            int length = 0;
                            while (writeBuffer.hasRemaining()){
                                length = channel.write(writeBuffer);
                                /*说明底层的socket写缓冲已满*/
                                if(length ==0){
                                    break;
                                }

                            }
                            //todo 清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
                            writeBuffer.compact();
                            /* todo 说明数据全部写入到底层的socket写缓冲区*/
                            if(length !=0){
                                /* todo 取消通道的写事件*/
                                selectionKey.interestOps(selectionKey.interestOps() &(~SelectionKey.OP_WRITE));
                            }
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
                selectionKey.cancel();
                try {
                    selectionKey.channel().close();
                    System.out.println("channel 已关闭");
                } catch (IOException e1) {
                    e1.printStackTrace();
                    System.out.println("channel 关闭异常");
                }
            }finally {
                try {
                    selector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("selector 关闭异常");
                }finally {
                    System.out.println("selector 已关闭");
                }
            }


        }

        public static void main(String[] args) throws InterruptedException {
             /*int OP_ACCEPT = 1 << 4;
            System.out.println(OP_ACCEPT);*/
            //System.out.println((~SelectionKey.OP_WRITE));
             int OP_WRITE = 1 << 2;
            System.out.println(OP_WRITE);
            Thread thread = new Thread(new TCPEchoServer(8080));
            thread.start();
            Thread.sleep(100000);
            thread.interrupt();
        }
    }
}
