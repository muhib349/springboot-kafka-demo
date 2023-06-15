package com.example.service;

import com.example.entity.WikimediaData;
import com.example.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaWikimediaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaWikimediaConsumer.class);

    private final WikimediaDataRepository repository;

    public KafkaWikimediaConsumer(WikimediaDataRepository repository) {
        this.repository = repository;
    }


    @KafkaListener(
            topics = "wikimedia-recent-change",
            groupId = "myGroup"
    )
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event message received -> %s", eventMessage));

        WikimediaData eventData = new WikimediaData();
        eventData.setWikiEventData(eventMessage);
        repository.save(eventData);
    }
}
