package com.gemini.web;

import com.gemini.stream.producer.MessageProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author xiaocuzi
 * @package com.gemini.web
 * @classname: KafakaProducerController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/4 21:33
 * @since 1.0.0
 */
@RestController
public class KafkaProducerController {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final  MessageProducerBean messageProducerBean;
    private final String topic;

    @Autowired
    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate,
                                   MessageProducerBean messageProducerBean, @Value("${kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.messageProducerBean = messageProducerBean;
        this.topic = topic;
    }

    @GetMapping("/message/send")
    public String sendMsg(@RequestParam String msg){

        ListenableFuture<SendResult<String, String>> sendResultListenableFuture = kafkaTemplate.send(topic, msg);
        try {
            return sendResultListenableFuture.get().toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;

    }

    @GetMapping("/message/send2")
    public String sendMsg2(@RequestParam String msg){
        messageProducerBean.send(msg);
        return "";
    }
}
