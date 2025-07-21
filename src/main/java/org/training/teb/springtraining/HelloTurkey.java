package org.training.teb.springtraining;

import org.springframework.stereotype.Component;

@Component("helloBean")
public class HelloWorld {

    public HelloWorld() {
        System.out.println("HelloWorld created");
    }

    public String hello(String name){
        return "Hello " + name;
    }

}
