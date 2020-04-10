package com.gemini.file;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;

import java.io.RandomAccessFile;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/7 22:38
 */
public class ClientHandler implements ChannelInboundHandler {
    private int byteRead;
    private volatile int lastLength = 0;
    private java.io.RandomAccessFile randomAccessFile;


    public ClientHandler(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive>>>>>>>>>>>>>>>>>>>");

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead>>>>>>>>>>>>>>>>>>>");

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelReadComplete>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("userEventTriggered>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelWritabilityChanged>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exceptionCaught>>>>>>>>>>>>>>>>>>>");
    }
}
