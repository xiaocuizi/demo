package com.gemini.pushJoke;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaocuzi
 * @package com.gemini.pushJoke
 * @classname: PushJokeController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2020/1/16 10:37
 * @since 1.0.0
 */
@RestController
public class PushJokeController {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    private Random random = new Random();



    /**
     * @return
     */
    @GetMapping("/pushJoke")
    public String news() {

        return "pushJoke";
    }


    /**
     * @param request
     * @return
     */
    @RequestMapping("/data")
    public DeferredResult<String> realTimeNews(HttpServletRequest request) {

        final DeferredResult<String> deferredResult = new DeferredResult<String>();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("xxxxxxxxxxxxxxxxxxxx");
//                int index = new Random().nextInt(100);
//                deferredResult.setResult(String.valueOf(index   ));

                deferredResult.setResult(String.valueOf(Jokes.jokes[random.nextInt(Jokes.jokes.length)]));
            }
        });
      return deferredResult;
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping("/data2")
    @ResponseBody
    public void push(HttpServletResponse response) {
        response.setContentType("text/event-stream");
       // response.setCharacterEncoding("utf-8");
        int sendCount = 0;

        try {
            PrintWriter writer = response.getWriter();
            while (true) {
                if (writer.checkError()) {
                    return;
                }
                sendCount++;
                Thread.sleep(2000);
                //int nextInt = random.nextInt(100);
                writer.write(String.valueOf(Jokes.jokes[random.nextInt(Jokes.jokes.length)]));
                writer.flush();
                if (sendCount > 99) {
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
