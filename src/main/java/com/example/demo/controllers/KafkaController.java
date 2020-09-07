package com.example.demo.controllers;

import com.example.demo.engine.KafkaConsumer;
import com.example.demo.engine.KafkaProducer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private static final Logger logger = LogManager.getLogger(KafkaConsumer.class);

    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer producer) {
        this.kafkaProducer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.kafkaProducer.sendMessage(message);
    }
}
