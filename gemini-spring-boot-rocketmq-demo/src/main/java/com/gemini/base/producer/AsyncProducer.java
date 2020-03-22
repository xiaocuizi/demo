package com.gemini.base.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
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
 * @classname: AsyncProducer
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/22 12:03
 */
public class AsyncProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("192.168.81.134:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("base", "Tag2", ("hello,world_" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("sendResult=%s", sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    System.out.printf("发送异常=%s", e);
                }
            });

            Thread.sleep(1000);
        }
        producer.shutdown();
    }
}


