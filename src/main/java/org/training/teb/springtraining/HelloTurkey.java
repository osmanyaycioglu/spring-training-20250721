package org.training.teb.springtraining;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component("helloTurkeyBean")
@DependsOn("helloBean")
public class HelloTurkey {


    public HelloTurkey() {
    }

//    public HelloTurkey() {
//        System.out.println("HelloTurkey created");
//    }

    public String hello(String name){
        return "Hello " + name;
    }

}
