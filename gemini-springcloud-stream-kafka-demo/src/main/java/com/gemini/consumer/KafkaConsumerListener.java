package com.gemini.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaocuzi
 * @package com.gemini.consumer
 * @classname: KafkaConsumerListener
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/4 21:44
 * @since 1.0.0
 */
@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "${kafka.topic}")
    public String onMsg(String msg){
        System.out.println("卡夫卡监听器...mgs="+msg);
        return msg;
    }

}
