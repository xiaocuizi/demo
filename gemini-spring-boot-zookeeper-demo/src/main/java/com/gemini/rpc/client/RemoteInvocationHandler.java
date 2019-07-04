package com.gemini.rpc.client;

import com.gemini.rpc.common.RpcRequest;
import com.gemini.rpc.common.RpcTransport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.rmi.rpc.client
 * @classname: RemoteInvocationHandler
 * @description: todo (用一句话描述该文件做什么)
 * @date 2018/12/10 16:29
 */
public class RemoteInvocationHandler implements InvocationHandler {

    String address;

    public RemoteInvocationHandler( String address) {
        this.address = address;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest(method.getDeclaringClass().getName(), method.getName(), args);
        RpcTransport transport = new RpcTransport(address);
        return transport.send(rpcRequest);
    }


}
