package com.gemini.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 服务器初始化器
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/3 19:07
 */
public class WServerInitialzer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // http编解码器
        pipeline.addLast(new HttpServerCodec());
        // 支持写大的数据流
        pipeline.addLast(new ChunkedWriteHandler());
         // 对httpMsg进行聚合，聚合成FullHttpRequest or FullHttpRepose
        pipeline.addLast(new HttpObjectAggregator(1024*64));
        //

        // websocket 服务器处理的协议，指定给客户端的路由
        // WebSocketServerProtocolHandler 会帮助开发者处理握手建立连接的动作 ，心跳
        // websocket都是以frams来传输，不同数据类型有不同的frames
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        // 自定义handler
        pipeline.addLast(new ChatHandler());


    }
}
