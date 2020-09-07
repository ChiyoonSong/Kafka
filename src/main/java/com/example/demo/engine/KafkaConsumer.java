package com.example.demo.engine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static final Logger logger = LogManager.getLogger(KafkaConsumer.class);

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = {"${spring.kafka.template.test-topic}"})
    public void ListenTestTopic(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.GROUP_ID) String groupId,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) Integer offset
    ) {
        logger.info("topic : {}", topic);
        logger.info("groupId : {}", groupId);
        logger.info("partition : {}", partition);
        logger.info("offset : {}", offset);
        logger.info("message : {}", message);
    }
}
