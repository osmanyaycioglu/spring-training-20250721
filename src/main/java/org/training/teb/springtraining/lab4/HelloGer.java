package org.training.teb.springtraining.lab4;

import org.springframework.stereotype.Component;

@Component
public class HelloGer implements IHello{
    @Override
    public String sayHello(final String name,
                           final String surname) {
        return "Hallo " + name + " " + surname;
    }

    @Override
    public String languageIndex() {
        return "ger";
    }
}
