package com.gemini.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

/**
 * @author xiaocuzi
 * @package com.gemini.bio
 * @classname: Client
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/3 17:45
 * @since 1.0.0
 */
@Slf4j
public class Client {
    private static  int default_server_port = 7779;
    private static  String default_server_ip = "127.0.0.1";

    public static void send(String expression){
        send(default_server_port,expression);
    }


    /**
     *
     * @param default_server_port
     * @param expression
     */
    private static void send(int default_server_port, String expression) {
        System.out.println(("表达式为：" + expression));
        Socket socket = null;
        BufferedReader in =null;
        PrintWriter out =  null;
        try {
            socket  =  new Socket(default_server_ip,default_server_port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println(expression);
            System.out.println(("结果为：" + in.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(("" + e.getLocalizedMessage()));
        }finally {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
                if(socket !=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(socket !=null){
                try {
                    socket.close();
                    System.out.println(("服务器已关闭，端口口：" + default_server_port));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
