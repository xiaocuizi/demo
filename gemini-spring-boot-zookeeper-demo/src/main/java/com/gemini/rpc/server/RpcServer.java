package com.gemini.rpc.server;

import com.gemini.rpc.annotation.PrcAnnotation;
import com.gemini.rpc.zk.IRegisterCenter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.rmi.rpc
 * @classname: RpcServer
 * @description: todo (用一句话描述该文件做什么)
 * @date 2018/12/10 16:03
 */
public class RpcServer {
    ExecutorService executorService = Executors.newCachedThreadPool();
    private IRegisterCenter registerCenter;

    private String serviceAddress;
    /**
     * 存放服务名称和服务对象之间关系
     */
    Map<String,Object> handlerMap = new ConcurrentHashMap<String, Object>();

    public RpcServer(IRegisterCenter registerCenter, String serviceAddress) {
        this.registerCenter = registerCenter;
        this.serviceAddress = serviceAddress;
    }


    /**
     * 绑定名称和服务对象
     * @param services
     */
    public void  bind(Object... services){
        for (Object service:services) {
            PrcAnnotation annotation = service.getClass().getAnnotation(PrcAnnotation.class);
            String name = annotation.value().getName();
            handlerMap.put(name,service);
        }
    }
    public void publisher() {

        try {
            String[] addrs = serviceAddress.split(":");
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(addrs[1]));

            for (String interfaceName:handlerMap.keySet()) {
               registerCenter.register(interfaceName,serviceAddress);
                System.out.println("注册服务成功，，"+interfaceName+"->"+handlerMap);
            }
            while (true) {
                System.out.println("------->服务端已启动，等待请求......");
                Socket socket = serverSocket.accept();
                executorService.execute(new ProccessHandler(socket, handlerMap));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
