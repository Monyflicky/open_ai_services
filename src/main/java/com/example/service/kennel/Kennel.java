package com.example.service.kennel;

import com.example.service.adoption.AdoptionController;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Kennel {
    @ApplicationModuleListener
    void on(AdoptionController.DogAdoptedEvent dogAdptedEvent) throws Exception{
        System.out.println("start dogAdptedEvent: " + dogAdptedEvent);
        Thread.sleep(5000);
        System.out.println("dogAdptedEvent: " + dogAdptedEvent);
        Thread.sleep(5000);
        System.out.println("stop dogAdptedEvent: " + dogAdptedEvent);
    }
}
