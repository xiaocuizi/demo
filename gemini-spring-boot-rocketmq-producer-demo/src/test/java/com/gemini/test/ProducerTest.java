package com.gemini.test;

import com.gemini.MQProducerApplication;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test
 * @classname: ProducerTest
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/22 18:27
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MQProducerApplication.class})
public class ProducerTest {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void test1() throws InterruptedException {
        DefaultMQProducer producer = rocketMQTemplate.getProducer();
        producer.setRetryTimesWhenSendFailed(7);
        // rocketMQTemplate.convertAndSend("springboot-mq","hello springboot rocketmq3");
        rocketMQTemplate.asyncSend("springboot-mq", "hello springboot rocketmq5", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("msg send success........thread name= {}",Thread.currentThread().getName());
            }

            @Override
            public void onException(Throwable e) {
                log.info("msg send onException........");
            }
        }, 1000);
        log.info("msg send end........thread name= {}",Thread.currentThread().getName());
        Thread.sleep(2000);
    }
}


