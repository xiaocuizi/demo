package com.gemini.rpc.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.rmi.rpc.client
 * @classname: RpcTransport
 * @description: todo (用一句话描述该文件做什么)
 * @date 2018/12/10 16:55
 */
public class RpcTransport {

    String address;


    public RpcTransport(String address) {
        this.address = address;
    }

    Socket newScoket(){
        System.out.println("newScoket:客户端创建scoket");

        try {
            String[] adds = address.split(":");
            Socket socket =   new Socket(adds[0],Integer.parseInt(adds[1]));
            return socket;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 发送请求
     * @param rpcRequest
     * @return
     */
    public Object send(RpcRequest rpcRequest) {
        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            socket = newScoket();
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object object = objectInputStream.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
