package org.training.teb.springtraining.lab4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("development")
@Configuration
public class HelloDevConfiguration {

    @Bean
    public IHello profileHello(){
        return new HelloTr();
    }

}

