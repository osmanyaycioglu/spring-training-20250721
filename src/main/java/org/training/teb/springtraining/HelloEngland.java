package org.training.teb.springtraining;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HelloEngland {


    public HelloEngland() {
    }

//    public HelloTurkey() {
//        System.out.println("HelloTurkey created");
//    }

    public String hello(String name){
        return "Hello " + name;
    }

}
