package com.example.service;

import com.example.service.publisher.CustomSpringEvent;
import com.example.service.publisher.CustomSpringEventListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
public class CustomSpringEventListenerTest {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    public void testOnApplicationEvent() {
        CustomSpringEventListener listener = new CustomSpringEventListener();
        String testMessage = "Hello, Spring Event!";
        CustomSpringEvent customEvent = new CustomSpringEvent(this, testMessage);
        listener.onApplicationEvent(customEvent);
        // Add assertions or log statements to verify event handling
    }
}
