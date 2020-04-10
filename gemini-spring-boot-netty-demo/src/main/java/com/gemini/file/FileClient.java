package com.gemini.file;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/7 22:35
 */
public class FileClient {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        RandomAccessFile randomAccessFile = new  RandomAccessFile("D:\\noi_37.data","rw");
        FileClient.connect("127.0.0.1",8023,randomAccessFile);
    }


    /**
     * @param host
     * @param port
     * @param randomAccessFile
     */
    public static void connect(String host, int port, RandomAccessFile randomAccessFile) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline().addLast(new ObjectEncoder());
                            ch.pipeline().addLast(new ObjectDecoder(ClassResolvers.weakCachingConcurrentResolver(null)));
                            ch.pipeline().addLast(new ClientHandler(randomAccessFile));
                        }
                    });
            ChannelFuture f = bootstrap.connect(host, port).sync();
            f.channel().closeFuture().sync();
            System.out.println("客户端连接结束...................");
        } finally {
            group.shutdownGracefully();
        }
    }
}
