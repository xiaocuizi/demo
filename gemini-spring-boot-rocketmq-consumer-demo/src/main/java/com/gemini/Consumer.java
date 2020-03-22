package com.gemini;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini
 * @classname: Consumer
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/22 18:35
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "springboot-mq", consumerGroup = "my-group")
public class Consumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("Receive message：" + message);
        // throw new RuntimeException("出错了啊。。。。。。。。。。");
    }
}

