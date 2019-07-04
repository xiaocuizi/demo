package com.gemini.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.controller
 * @classname: HystrixController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/24 18:11
 */
@RestController
public class HystrixController {

    public static Random random =  new Random();

    /**
     * hello-world超时或失败，errorContent替代方案
     * {@link #errorContent}
     * @return
     */
    @GetMapping("hello-world")
    @HystrixCommand(fallbackMethod = "errorContent"
            ,commandProperties={@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "100")})
    public String helloWorld() throws InterruptedException {
        int sleepTime = random.nextInt(200);
        System.out.println("sleepTime="+sleepTime);
        Thread.sleep(sleepTime);
        String property = System.getProperty("my.name");

        System.out.println("==========================");
        System.out.println("====property="+property);
        return "hello-world";
    }

    public String errorContent(){
        return "Fail";
    }
    @GetMapping("hello-world-2")
    public String helloWorld2(){
        return new HelloWorldCommand().execute();
    }
    private class HelloWorldCommand extends com.netflix.hystrix.HystrixCommand<String>{

        public HelloWorldCommand() {
            super(HystrixCommandGroupKey.Factory.asKey("helloWorld"),100);
        }

        /**
         * Implement this method with code to be executed when {@link #execute()} or {@link #queue()} are invoked.
         *
         * @return R response type
         * @throws Exception if command execution fails
         */
        @Override
        protected String run() throws Exception {
            int value = random.nextInt(200);
            System.out.println("cost time="+value);
            if(value >100){

                //throw new RuntimeException("超时了！！！");
                return "faild";
            }
            return "hello world";
        }


    }
}
