package com.gemini.asnyc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;

/**
 * @author xiaocuzi
 * @package com.gemini.asnyc
 * @classname: AsyncController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2020/1/19 21:53
 * @since 1.0.0
 */
@Controller
public class AsyncController {

    @Autowired
    private org.springframework.data.redis.core.RedisTemplate redisTemplate;

    /**
     * @return
     */
    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult<Object> createOrder() {
        DeferredResult<Object> deferredResult = new DeferredResult<Object>
                (5000L, "FAILE");
        DeferredResultQueue.setQueues(deferredResult);
        return deferredResult;

    }

    @RequestMapping("/create")
    @ResponseBody
    public String create() {
        String order = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = DeferredResultQueue.getQueues();
        deferredResult.setResult(order);
        return "success-->" + order;
    }
}
