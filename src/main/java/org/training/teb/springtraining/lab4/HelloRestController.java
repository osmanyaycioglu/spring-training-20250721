package org.training.teb.springtraining.lab4;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloRestController {
    private IHello hello;
    private IHello profHello;

    public HelloRestController(@Qualifier("helloDynamic") final IHello helloParam,
                               @Qualifier("profileHello") final IHello helloProfParam) {
        hello     = helloParam;
        profHello = helloProfParam;
    }

    @GetMapping("/say/hello")
    public String sayHello(@RequestParam String name,
                           @RequestParam String surname) {
        return hello.sayHello(name,
                              surname);
    }

    @GetMapping("/say/profile")
    public String sayHelloProf(@RequestParam String name,
                               @RequestParam String surname) {
        return profHello.sayHello(name,
                                  surname);
    }

}
