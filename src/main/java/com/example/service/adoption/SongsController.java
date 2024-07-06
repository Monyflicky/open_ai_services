package com.example.service.adoption;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SongsController {
    /*@Autowired
    private final ChatClient chatClient;

    public SongsController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/iia")
    public String printString(){
        return "hello";
    }
    @GetMapping("/ai")
    public String getOutParsedByAI(@RequestParam(value = "message", defaultValue = "Where is Canada going in the election of 2024?") String artist){
        var message = """
                      Please give me a list of top 10 songs by the {artist}?
                """;

        PromptTemplate template = new PromptTemplate(message, Map.of("artist", artist));
        Prompt prompt = template.create();
        return prompt.getContents();
    }*/
}
