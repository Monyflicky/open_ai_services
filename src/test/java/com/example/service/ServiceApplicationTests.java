package com.example.service;

import com.example.service.publisher.CustomSpringEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
class ServiceApplicationTests {
	@Autowired
	private ApplicationEventPublisher publisher;

	@Test
	void contextLoads() {
	}

	@Test
	void textApplicationListener(){
       String message = "Narrator has come";
		CustomSpringEvent event = new CustomSpringEvent(this, message);

		publisher.publishEvent(event);
	}
}
