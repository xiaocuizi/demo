package com.gemini.raw;

import com.fasterxml.jackson.databind.JsonSerializable;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author xiaocuzi
 * @package com.gemini.raw
 * @classname: KafkaProducerDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/4 21:01
 * @since 1.0.0
 */
public class KafkaProducerDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //初始化配置
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","localhost:9092");

        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        KafkaProducer  KafkaProducer = new KafkaProducer(properties);
        String topic = "gupao";
        String key = "messsageKey";
        String value = "this is value";
        Integer partition = 0;
        Long time = System.currentTimeMillis();
        ProducerRecord<String,String> producerRecord = new ProducerRecord<String, String>(topic,partition,time,key,value);
        Future<RecordMetadata> send = KafkaProducer.send(producerRecord);
        RecordMetadata recordMetadata = send.get();
        System.out.println("recordMetadata->"+recordMetadata.toString());
    }
}
