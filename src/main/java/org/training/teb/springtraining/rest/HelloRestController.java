package org.training.teb.springtraining.rest;

import a.b.c.MyOtherBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Repository
//@Service
//@Configuration

//@Controller
//@ResponseBody

@RestController("helloR")
@RequestMapping("/my")
public class HelloRestController {

    @Autowired
    private MyOtherBean myOtherBean;

    // @RequestMapping(path = "/my/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/hello")
    public String helloPost() {
        return "hello - POST";
    }

    @PutMapping("/hello")
    public String helloPut() {
        return "hello - PUT";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam("name") String name) {
        return "Greetings " + name;
    }

    @GetMapping("/greeting2")
    public String greeting(@RequestParam("name") String name,
                           @RequestParam("surname") String surname) {
        return "Greetings " + name + " " + surname;
    }

    @GetMapping("/greeting3/{name}")
    public String greeting3(@PathVariable("name") String name) {
        return "Greetings 3 " + name;
    }

    @GetMapping("/greeting4/{name}/sss/{sn}")
    public String greeting4(@PathVariable("name") String name,
                            @PathVariable("sn") String surname) {
        return "Greetings 4 " + name + " " + surname;
    }

    @GetMapping("/greeting5/{name}")
    public String greeting5(@PathVariable("name") String name,
                            @RequestParam("surname") String surname) {
        return "Greetings 5 " + name + " " + surname;
    }


    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }

}
