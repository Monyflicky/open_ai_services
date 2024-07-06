package com.example.service.publisher;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEvent extends ApplicationEvent {  //custom events
    private String message;
    public CustomSpringEvent(Object source, String message){
        super(source);
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}