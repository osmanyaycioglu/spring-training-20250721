package org.training.teb.springtraining.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.training.teb.springtraining.lab4.HelloEng;
import org.training.teb.springtraining.lab4.HelloEsp;
import org.training.teb.springtraining.lab4.HelloTr;
import org.training.teb.springtraining.lab4.IHello;

@Configuration
public class PropertyConfiguration {

    @Autowired
    private Environment environment;

    @Autowired
    private MyProps myProps;


    public IHello testHello(){
        String propertyLoc = environment.getProperty("app.language");
        switch (propertyLoc) {
            case "eng":
                return new HelloEng();
            case "tr":
                return new HelloTr();
            case "esp":
                return new HelloEsp();
            default:
                return new HelloEng();
        }
    }

    @Bean
    public IHello testHello2(@Value("${app.language}") String language) {
        switch (language) {
            case "eng":
                return new HelloEng();
            case "tr":
                return new HelloTr();
            case "esp":
                return new HelloEsp();
            default:
                return new HelloEng();
        }
    }
}
