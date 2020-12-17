package cn.zack.kafkademo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "user-topic")
    public void comsumer(ConsumerRecord<?, ?> record){
        Object value = record.value();
        log.info("收到消息: {}", value);
    }
}