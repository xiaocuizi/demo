package com.gemini.netty;

import com.gemini.nio.buffer.TcpServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author xiaocuzi
 * @package com.gemini.nio.buffer
 * @classname: NettyServer
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/7 20:57
 * @since 1.0.0
 */
public class NettyServer {
    private static final String IP  = "127.0.0.1";
    private static final int PORT = 6666;
    //CPU核数两倍大小
    private static final int BIzGGOUPSIZE = Runtime.getRuntime().availableProcessors();
    private static final int biz_thread_size = 100;

    private static final EventLoopGroup bossGoup = new NioEventLoopGroup(BIzGGOUPSIZE) ;
    private static final EventLoopGroup workeGroup = new NioEventLoopGroup(biz_thread_size);

    public static void  start() throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGoup,workeGroup)
        .channel(NioServerSocketChannel.class)
        .childHandler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                ChannelPipeline pipeline = channel.pipeline();
                pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
                pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                //TODO 咱们自己的业务一定要是最后一个
                pipeline.addLast(new TcpServerHandler());

            }
        });
        ChannelFuture channelFuture = serverBootstrap.bind(IP, PORT).sync();
        channelFuture.channel().closeFuture().sync();
    }
    public static void shutdonw(){
        bossGoup.shutdownGracefully();
        workeGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws InterruptedException {
        NettyServer.start();
        System.out.println("begin server start...........");
    }


}
