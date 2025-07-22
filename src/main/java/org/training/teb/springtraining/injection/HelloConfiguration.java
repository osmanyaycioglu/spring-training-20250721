package org.training.teb.springtraining.injection;

import a.b.c.MyOtherBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.training.teb.springtraining.HelloWorld;

@Configuration
public class HelloConfiguration {

    @Bean
    @Qualifier("haName")
    public HelloWorld myHello(MyOtherBean myOtherBeanParam) {
        myOtherBeanParam.otherMethod();
        return new HelloWorld();
    }

    @Bean("anotherHello")
    public HelloWorld myHello2() {
        return new HelloWorld();
    }

}
