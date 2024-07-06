package com.example.service;

import com.example.service.publisher.CustomSpringEventPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
public class CustomSpringEventPublisherTest {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    public void testPublishCustomEvent() {
        CustomSpringEventPublisher publisher = new CustomSpringEventPublisher();
        String testMessage = "Hello, Spring Event!";
        publisher.publishCustomEvents(testMessage);
        // Add assertions or log statements to verify the event publishing
    }
}
