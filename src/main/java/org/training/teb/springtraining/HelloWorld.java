package org.training.teb.springtraining;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component("helloBean")
@Primary
// @Scope("prototype")
public class HelloWorld {

    private long counter;

    public HelloWorld() {
        System.out.println("HelloWorld created");
    }

    public String hello(String name) {
        counter++;
        return "Hello " + name + " counter : " + counter;
    }

    @Async
    public Future<String> asyncHello(String name) {
        CompletableFuture<String> objectCompletableFutureLoc = new CompletableFuture<>();
        objectCompletableFutureLoc.complete("Hello " + name + " counter : " + counter);
        return objectCompletableFutureLoc;
    }

}
