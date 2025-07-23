package org.training.teb.springtraining.lab4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.training.teb.springtraining.lab4.condition.CheckProperty;

//@Profile("live")
@CheckProperty(prop = "app.type",val = "live")
@Configuration
public class HelloLiveConfiguration {

    @Bean
    public IHello profileHello(){
        return new HelloEng();
    }

}

