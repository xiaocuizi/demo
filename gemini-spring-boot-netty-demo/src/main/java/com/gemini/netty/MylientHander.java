package com.gemini.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author xiaocuzi
 * @package com.gemini.netty
 * @classname: MylientHander
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/7 22:32
 * @since 1.0.0
 */
public class MylientHander extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("【客户端】接收到【消息】msg="+msg);
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        System.out.println("客户端异常。"+cause.getMessage());
    }
}
