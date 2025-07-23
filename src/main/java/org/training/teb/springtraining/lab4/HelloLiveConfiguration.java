package org.training.teb.springtraining.lab4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("live")
@Configuration
public class HelloLiveConfiguration {

    @Bean
    public IHello profileHello(){
        return new HelloEng();
    }

}

