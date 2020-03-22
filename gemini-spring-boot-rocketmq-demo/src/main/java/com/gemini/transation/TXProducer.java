package com.gemini.transation;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
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
public class TXProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException, UnsupportedEncodingException {
        // 事务生产者
        TransactionMQProducer producer = new TransactionMQProducer("group1");
        producer.setNamesrvAddr("192.168.81.134:9876");
        // 设置监听器
        producer.setTransactionListener(new TransactionListener() {

            // 执行本地的事务
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                if (StringUtils.equals("TAGA", msg.getTags())) {
                    return LocalTransactionState.COMMIT_MESSAGE;
                } else if (StringUtils.equals("TAGB", msg.getTags())) {
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                } else if (StringUtils.equals("TAGC", msg.getTags())) {
                    return LocalTransactionState.UNKNOW;
                }
                return LocalTransactionState.UNKNOW;
            }


            // MQ进行事务状态的回查
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.printf("回查:消息的Tag=%s", msg.getTags());
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        producer.start();
        System.out.printf("生成者启动。。。。。。。。。。。%s%n",1);
        String[] tags = {"TAGA", "TAGB", "TAGC"};
        for (int i = 0; i < 3; i++) {
            Message msg = new Message("transactionTopic", tags[i], "key_" + i, ("hello,world_" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.sendMessageInTransaction(msg, null);
            System.out.printf("%s%n", sendResult);
            Thread.sleep(1000);
        }
        // producer.shutdown();
    }
}


