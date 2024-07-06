package com.example.service.adoption;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

   /* @GetMapping
    public ChatResponse generate(@RequestParam(value = "message", defaultValue = "Tell me are black girls sexy?") String message){
       return chatClient.call(new Prompt(message));
    }*/

    @GetMapping("/ai")
    String generation(@RequestParam(value = "message", defaultValue = "Are black women gorgeous?") String userInput) {
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }
}
