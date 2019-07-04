package com.gemini.bio;

import com.sun.xml.internal.ws.handler.ServerLogicalHandlerTube;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xiaocuzi
 * @package com.gemini.bio
 * @classname: Server
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/3 16:33
 * @since 1.0.0
 */
@Slf4j
public class Server {
    private static int default_port = 7779;
    /**
     * 单例的ServerSokcket
     */
    private static ServerSocket serverSocket;


    public static void start() throws IOException {
        start(default_port);
    }

    /**
     * @param default_port
     */
    private static void start(int default_port) {
        if (serverSocket != null) {
            return;
        }

        try {
            serverSocket = new ServerSocket(default_port);
            System.out.println(("服务器已启动，端口：" + default_port));
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                /*try {
                    //serverSocket.close();
                    //System.out.println(("服务器已关闭，端口口：" + default_port));
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
        }

    }
}
