package com.example.service;

import com.example.handler.WikimediaChangesHandler;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia-recent-change";

        BackgroundEventHandler eventHandler = new WikimediaChangesHandler(topic, kafkaTemplate);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";


        EventSource.Builder eventSource = new EventSource
                .Builder(URI.create(url));

        BackgroundEventSource eventSource1 = new BackgroundEventSource
                .Builder(eventHandler, eventSource)
                .build();

        eventSource1.start();

        TimeUnit.MINUTES.sleep(10);
    }
}
