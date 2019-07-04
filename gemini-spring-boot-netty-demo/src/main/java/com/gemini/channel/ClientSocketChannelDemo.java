package com.gemini.channel;

import com.gemini.buffer.Buffers;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @author xiaocuzi
 * @package com.gemini.channel
 * @classname: ClientSocketChannelDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/7 16:46
 * @since 1.0.0
 */
public class ClientSocketChannelDemo {

    public static class TCPEchoClient implements Runnable{
        private String threadName;
         //服务端地址
        private InetSocketAddress remoteAddress;

         private Random random  = new Random();
        public TCPEchoClient(String threadName, InetSocketAddress remoteAddress) {
            this.threadName = threadName;
            this.remoteAddress = remoteAddress;
        }

        @Override
        public void run() {
            Charset charset = Charset.forName("UTF-8");
            Selector selector = null;
            try {
                //TODO 选择器
                selector = Selector.open();
                //TODO 通道
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(false);
                //TODO 注册通道
                socketChannel.register(selector,SelectionKey.OP_READ | SelectionKey.OP_WRITE,new Buffers(256,256));
                //TODO 建立连接   //TODO 绑定服务地址
                socketChannel.connect(remoteAddress);
                //TODO 等待三次握手
                while (!socketChannel.finishConnect()){
                    ;
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("客户端发生异常");
                return;
            }


            try {
                int index = 1;
                while (!Thread.currentThread().isInterrupted()) {
                    //TODO 阻塞等待
                    selector.select();
                    /* todo Set中的每个key代表一个通道*/
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
                    while (selectionKeyIterator.hasNext()){
                        SelectionKey key = selectionKeyIterator.next();
                        selectionKeyIterator.remove();;
                        Buffers buffers = (Buffers) key.attachment();
                        ByteBuffer readBuffer = buffers.getReadBuffer();
                        ByteBuffer writeBuffer = buffers.getWriteBuffer();
                        /*todo 通过SelectionKey获取通道对应的缓冲区*/
                        SocketChannel channel = (SocketChannel) key.channel();
                        if(key.isReadable()){
                            channel.read(readBuffer);
                            readBuffer.flip();
                            //TODO 显示通道返送的信息
                            CharBuffer charBuffer = charset.decode(readBuffer);
                            System.out.println("通道发送的信息是："+threadName+"->"+index+","+charBuffer.toString());
                            readBuffer.clear();
                        }
                        //
                        if(key.isWritable()){
                            writeBuffer.put((threadName+"->"+index).getBytes("UTF-8"));
                            writeBuffer.flip();
                            channel.write(writeBuffer);
                            writeBuffer.clear();
                            index++;
                        }
                    }
                    Thread.sleep(1000 + random.nextInt(1000));
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                System.out.println(threadName +"-> exception.");
            }finally {
                try {
                    selector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(threadName +"-> closed failed");
                }finally {
                    System.out.println(threadName +"-> closed.");
                }
                ;
            }






        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*注册感兴趣事件*/
        int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        System.out.println(interestSet);
        InetSocketAddress remoteAddress = new InetSocketAddress("127.0.0.1", 8080);
        Thread thread_a = new Thread(new TCPEchoClient("THREAD A", remoteAddress));

        Thread thread_b = new Thread(new TCPEchoClient("THREAD B", remoteAddress));

        Thread thread_c = new Thread(new TCPEchoClient("THREAD C", remoteAddress));

        Thread thread_d = new Thread(new TCPEchoClient("THREAD D", remoteAddress));

        thread_a.start();
        thread_b.start();
        thread_c.start();
//        thread_d.start();

        Thread.sleep(5000);

        thread_a.interrupt();
        thread_d.start();

    }
}
