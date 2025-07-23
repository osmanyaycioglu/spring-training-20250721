package org.training.teb.springtraining.lab4;

import org.springframework.stereotype.Component;

@Component
public class HelloEng implements IHello{
    @Override
    public String sayHello(final String name,
                           final String surname) {
        return "Hello " + name + " " + surname;
    }

    @Override
    public String languageIndex() {
        return "eng";
    }
}
