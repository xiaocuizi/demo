package com.gemini.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author xiaocuzi
 * @package com.gemini.netty
 * @classname: NettyClient
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/7 22:21
 * @since 1.0.0
 */
public class NettyClient implements Runnable {
    @Override
    public void run() {
        //事件轮询器
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(group);
            bootstrap.channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline =ch.pipeline();
                            pipeline.addLast("frameDecoder",new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
                            pipeline.addLast("frameEncoder",new LengthFieldPrepender(4));
                            pipeline.addLast("decoder",new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast("encoder",new StringEncoder(CharsetUtil.UTF_8));
                            pipeline.addLast("handler",new MylientHander());
                        }
                    });
            for (int i = 0; i <1000 ; i++) {
                ChannelFuture cf = bootstrap.connect("127.0.0.1", 6666).sync();
                cf.channel().writeAndFlush("【您好，服务端->"+Thread.currentThread().getName()+"->"+i+"】");
                cf.channel().closeFuture().sync();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println( (Thread.currentThread().getName()+"->"+i));
         new Thread(new NettyClient()).start();
        }
    }
}
