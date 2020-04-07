package com.gemini.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/2 20:53
 */
public class HelloServer {
    public static void main(String[] args) throws Exception {
        // 线程组
        EventLoopGroup main = new NioEventLoopGroup(1);
        // 从线程组
        EventLoopGroup worker = new NioEventLoopGroup(2);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(main,worker);
            serverBootstrap.channel(NioServerSocketChannel.class)
                    .childHandler(new HelloServerInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(8081).sync();
            // 监听关闭的channel ,设置为同步方式
            System.out.println("Server started.............");
            channelFuture.channel().closeFuture().sync();

        } finally {
            main.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }
}
