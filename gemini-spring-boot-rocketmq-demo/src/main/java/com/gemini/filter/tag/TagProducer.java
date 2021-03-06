package com.gemini.filter.tag;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.base
 * @classname: Producer
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/22 10:56
 */
public class TagProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException, UnsupportedEncodingException {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("192.168.81.134:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("tagTopic", "Tag3", "key_" + i, ("hello,world_" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            SendStatus sendStatus = sendResult.getSendStatus();
            String msgId = sendResult.getMsgId();
            int queueId = sendResult.getMessageQueue().getQueueId();
            System.out.printf("%s%n", sendResult);
            Thread.sleep(1000);
        }
        producer.shutdown();
    }
}


