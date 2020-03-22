package com.gemini;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini
 * @classname: ConsumerMessageListener
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/22 18:54
 */
public class ConsumerMessageListener implements MessageListenerConcurrently {
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        return null;
    }
}


