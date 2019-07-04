package com.gemini.nio.buffer;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @author xiaocuzi
 * @package com.gemini.nio.buffer
 * @classname: TcpServerHandler
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/7 21:49
 * @since 1.0.0
 */
public class TcpServerHandler extends ChannelInboundHandlerAdapter {
    /**
     *  传播事件，通过Pipeline
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //super.channelActive(ctx);
        System.out.println("【server】通道是激活的。。。。");
    }

    /**
     *  可读
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
       // super.channelRead(ctx, msg);
        System.out.println("【server】接收客户端【消息】msg="+msg);
        ctx.channel().writeAndFlush("hello客户端，我是服务端~~~~");
        ctx.close();
    }

    /**
     * 异常
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        System.out.println("get exceptioin."+cause.getMessage());
    }
}
