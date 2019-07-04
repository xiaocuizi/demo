package com.gemini.stream.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author xiaocuzi
 * @package com.gemini.stream.piroducer
 * @classname: MessageProducerBean
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/5 11:31
 * @since 1.0.0
 */
@Component
@EnableBinding(Source.class)
public class MessageProducerBean {


    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel messageChannel;

    @Autowired
    private Source source;


    /**
     * 消息分为消息头，消息体（Body、PayLaod）
     * @param msg
     */
    public void send(String msg){
        //messageChannel.send(MessageBuilder.withPayload(msg).build());
        source.output().send(MessageBuilder.withPayload(msg).build());
    }
}
