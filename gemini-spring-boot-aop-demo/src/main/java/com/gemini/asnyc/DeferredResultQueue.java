package com.gemini.asnyc;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author xiaocuzi
 * @package com.gemini.asnyc
 * @classname: DeferredResultQueue
 * @description: todo (用一句话描述该文件做什么)
 * @date 2020/1/19 21:59
 * @since 1.0.0
 */
public class DeferredResultQueue {

    private static Queue<DeferredResult<Object>> queues = new ConcurrentLinkedDeque<>();

    public static void setQueues(DeferredResult<Object> obj) {
        int size = queues.size();
        if (size > 100) {
            return;
        }
        queues.add(obj);
    }

    public static DeferredResult<Object> getQueues() {
        return queues.poll();
    }
}
