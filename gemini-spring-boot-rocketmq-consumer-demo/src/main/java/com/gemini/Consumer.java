package com.gemini;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.List;

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
public class Consumer implements RocketMQListener<MessageExt> , MessageListenerConcurrently {

    @Override
    public void onMessage(MessageExt message) {
        log.info("Receive message：" + message);
        // throw new RuntimeException("出错了啊。。。。。。。。。。");
    }

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
    }
}

