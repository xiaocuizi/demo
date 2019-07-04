package com.gemini.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author xiaocuzi
 * @package com.gemini.bio
 * @classname: ServerHandler
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/3 16:46
 * @since 1.0.0
 */
@Slf4j
public class ServerHandler implements Runnable {
    private Socket socket;
    public ServerHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out =  null;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            String expression;
            String result;

            while (true){
              if((expression = in.readLine())==null){
                  break;
              }
              log.info("服务端收到信息。"+expression);
              result = Calculator.cal(expression).toString();
              out.println(result);
            }

        } catch (IOException e) {
            e.printStackTrace();
            log.error("ServerHandler:异常"+e.getLocalizedMessage());
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
        }
    }
}
