package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaWikimediaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaWikimediaConsumer.class);

    @KafkaListener(
            topics = "wikimedia-recent-change",
            groupId = "myGroup"
    )
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event message received -> %s", eventMessage));
    }
}
