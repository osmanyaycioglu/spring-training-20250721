package org.training.teb.springtraining;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("helloBean")
// @Scope("prototype")
public class HelloWorld {

    private long counter;

    public HelloWorld() {
        System.out.println("HelloWorld created");
    }

    public String hello(String name){
        counter++;
        return "Hello " + name + " counter : " + counter;
    }

}
