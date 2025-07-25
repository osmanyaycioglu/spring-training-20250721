package org.training.teb.springtraining.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.teb.springtraining.aspect.Callee;
import org.training.teb.springtraining.aspect.LogDelta;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloRestController {
    private IHello hello;
    private IHello profHello;

    @Autowired
    private Callee callee;

    public HelloRestController(@Qualifier("helloDynamic") final IHello helloParam,
                               @Qualifier("profileHello") final IHello helloProfParam) {
        hello     = helloParam;
        profHello = helloProfParam;
    }

    @LogDelta(prefix = "rest.call.callee")
    @GetMapping("/call/callee")
    public String sayHello(@RequestParam String name) {
        return callee.callMe(name);
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
