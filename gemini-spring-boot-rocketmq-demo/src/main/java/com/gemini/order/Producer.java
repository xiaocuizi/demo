package com.gemini.order;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.order
 * @classname: Producer
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/22 14:42
 */
public class Producer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("192.168.81.134:9876");
        producer.start();
        List<OrderStep> orderSteps = OrderStep.buildOrders();
        //  发送消息
        for (int i = 0; i < orderSteps.size(); i++) {
            String body = String.valueOf(orderSteps.get(i));
            Message msg = new Message("orderTopic2", "order", "i" + i, body.getBytes());
            // msg消息
            // 消息队列选择器
            // 选择的唯一标识
            producer.send(msg, new MessageQueueSelector() {
                /**
                 *
                 * @param mqs 队列集合
                 * @param msg 消息对象
                 * @param arg  业务标识的参数
                 * @return
                 */
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    long orderId = (long) arg;
                    // 取模
                    long index = orderId % mqs.size();
                    System.out.printf("orderId=%s,index=%s%n", orderId, index);
                    return mqs.get(Integer.valueOf(String.valueOf(index)));
                }
            }, orderSteps.get(i).getOrderId());
        }
        producer.shutdown();
    }
}


