package org.training.teb.springtraining.lab4;

import org.springframework.stereotype.Component;

@Component
public class HelloEsp implements IHello{
    @Override
    public String sayHello(final String name,
                           final String surname) {
        return "Ola " + name + " " + surname;
    }

    @Override
    public String languageIndex() {
        return "esp";
    }

}
