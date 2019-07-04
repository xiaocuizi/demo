package com.gemini.rpc.server;

import com.gemini.rpc.zk.IRegisterCenter;
import com.gemini.rpc.zk.RegisterCenterImpl;

import java.io.IOException;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.rmi.rpc.server
 * @classname: RPCServerDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2018/12/10 17:51
 */
public class RPCServerDemo {
    public static void main(String[] args) throws IOException {
        IRegisterCenter registerCenter = new RegisterCenterImpl();
        RpcServer rpcServer = new RpcServer(registerCenter, "127.0.0.1:8080");
        rpcServer.bind(new GPHelloImpl());
        rpcServer.publisher();
        System.out.println("--------->服务端发布服务成功..");
        System.in.read();
    }
}
