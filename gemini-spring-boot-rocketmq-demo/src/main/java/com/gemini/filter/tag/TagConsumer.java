package com.gemini.filter.tag;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.base.customer
 * @classname: TagConsumer
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/22 12:46
 */
public class TagConsumer {

    public static void main(String[] args) throws MQClientException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");

        consumer.setNamesrvAddr("192.168.81.134:9876");
        consumer.subscribe("tagTopic", "*");
        // 消费者模式默认是负载均衡模式
        // consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            // 接收消息内容
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.printf("msgId=%s,ID=%s,costTime=%s%n", msg.getMsgId(), new String(msg.getBody()), (System.currentTimeMillis() - msg.getStoreTimestamp()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}


