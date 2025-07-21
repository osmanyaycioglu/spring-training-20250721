package org.training.teb.springtraining;

import org.springframework.stereotype.Component;

@Component("helloTurkeyBean")
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
