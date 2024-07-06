package com.example.service.adoption;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Assistant {

    @Bean
    ChatClient chatClient(VectorStore vs, ChatClient.Builder builder){
        var systemPrompt = """
                You are an AI powered assistant to help people adopt a dog from the adoption agency
                Spring's Pet Emporium with locations in Krakow, Singapore, Paris, London and San Francisco.
                If you don't know about the dogs housed at our particular stores, then return a disaapointed\s
                response suggesting we don't/s have any dogs available.
               
                """;
        return builder
                .defaultAdvisors(new QuestionAnswerAdvisor(vs, SearchRequest.defaults()))
                .defaultSystem(systemPrompt).build();
    }

    @Bean
    ApplicationRunner assistantDemo(
            DogRepository repository,
            VectorStore vectorStore,
            ChatClient chatClient){

        return args -> {
           /* repository.findAll().forEach(dog -> {
                var document = new Document("name: " +
                        dog.name() + "breed: " + dog.breed() + "age: " + dog.age());
                Map.of("dogId", dog.id());

                vectorStore.add(List.of(document));
            });*/

            var userPrompt = """
                        Give me the ages of the dogs that you have.
                        """;
            var content = chatClient.prompt()
                    .user( userPrompt)
                    .call()
                    .content();

            System.out.println("content: [" + content + "]");
        };
        /*return new ApplicationRunner(){
            @Override
            public void run(ApplicationArguments arg) throws Exception{
                var userPrompt = """
                        Give me the ages of the dogs that you have.
                        """;
                var content = chatClient.prompt()
                        .user( userPrompt)
                        .call()
                        .content();

                System.out.println("content: [" + content + "]");
            }
        };*/
    }
}
