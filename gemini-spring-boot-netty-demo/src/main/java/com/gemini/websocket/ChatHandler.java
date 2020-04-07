package com.gemini.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;

/**
 * 通讯处理类
 * TextWebSocketFrame 处理文本的Frame,Frame为消息的载体
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/3 19:20
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String clientMsg = msg.text();
        System.out.printf("接收到的消息clientMsg=%s", clientMsg);
        // 发送给所有的客户端  第一种写法
        for (Channel channel : clients) {
            //  ChannelFuture writeAndFlush(Object msg)，该方法中的msg，不可以为String类型
            //  因为channel中消息的载体都是Frame
            channel.writeAndFlush(new TextWebSocketFrame("【服务器在】" + LocalDateTime.now() + ",消息为:" + clientMsg));
        }
        // 第二种写法
        // clients.writeAndFlush(new TextWebSocketFrame("【服务器在】" + LocalDateTime.now() + ",消息为:" + clientMsg));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 获取当前客户端所对应的chanel
        Channel channel = ctx.channel();
        // 添加到管理组
        clients.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 用户离开或者说关闭浏览器
        // 当触发handler,时候，ChannelGroup会自动移除对应客户端的channel
        // clients.remove(ctx.channel());

        //id()，有长id，还有短id，系统流量大的话，用asLongTextId
        System.out.printf("channelId=%s%n", ctx.channel().id());
        System.out.printf("长channelId=%s%n", ctx.channel().id().asLongText());
        System.out.printf("短channelId=%s%n", ctx.channel().id().asShortText());


    }
}
