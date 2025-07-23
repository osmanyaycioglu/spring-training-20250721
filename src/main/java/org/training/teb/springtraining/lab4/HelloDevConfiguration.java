package org.training.teb.springtraining.lab4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.training.teb.springtraining.lab4.condition.CheckProperty;

// @Profile("development")
@CheckProperty(prop = "app.type",val = "dev")
@Configuration
public class HelloDevConfiguration {

    @Bean
    public IHello profileHello(){
        return new HelloTr();
    }

}

