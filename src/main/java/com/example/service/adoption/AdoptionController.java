package com.example.service.adoption;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@ResponseBody
@Transactional
public class AdoptionController {
    private final DogRepository repository;
    private final ApplicationEventPublisher publisher;
    public AdoptionController(DogRepository repository, ApplicationEventPublisher publisher){
        this.repository = repository;
        this.publisher = publisher;
    }
    @RequestMapping("/reader/{num}")
    void read(@PathVariable int num){
        System.out.println(num);
    }
     @RequestMapping("/adoptions/{dogId}")
     void adopt(@PathVariable Integer dogId, @RequestBody Map<String, String> body){
         var name = body.get("name");
         this.repository.findById(dogId).ifPresent(
                 dog -> {
                     var nDog = new Dog(dog.id(), dog.name(), dog.breed(), dog.age());
                     var adopted = this.repository.save(nDog);
                     System.out.println("adopted [" + adopted + "]");
                     this.publisher.publishEvent(new DogAdoptedEvent(dogId));
                 });

     }

    //Data Oriented Programming
    // - sealed types
    // -records
    // - pattern matching
    // - smart switch expressions
    // name + tuple = record, sequence of typed data in a bucket

   public record DogAdoptedEvent(int godId){

   }

}
    //no lombok

    /*class Loans {
        String displayMessageFor(Loan loan){
            // var message = "";

            return switch (loan) {
                case UnSecuredLoan(var interest) -> "ouch. that " + interest + "% is going to hurt";
                case SecuredLoan sl -> "hey. good job. well done. you got a good loan";
            };

             var message = "";
             if(loan instanceof SecuredLoan){
                 message = "hey. good job. well done. you got a good loan";
             }

             if(loan instanceof UnSecuredLoan(var interest)){
                 //var usl = (UnSecuredLoan) loan;
                 message = "ouch. that " + interest + "% is going to hurt";
             }
        }
    }

    sealed interface Loan permits SecuredLoan, UnSecuredLoan{}

    final class SecuredLoan implements Loan{}

    record UnSecuredLoan(float interest) implements Loan{}*/


