package org.training.teb.springtraining.lab3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfiguration {

    @Bean
    public Add add1(){
        return new Add(0);
    }

    @Bean
    public Add add2(){
        return new Add(1);
    }

    @Bean
    public Add add3(){
        return new Add(2);
    }

    @Bean
    public Subs subs1(){
        return new Subs(0);
    }
    @Bean
    public Subs subs2(){
        return new Subs(1);
    }
    @Bean
    public Subs subs3(){
        return new Subs(2);
    }


}
