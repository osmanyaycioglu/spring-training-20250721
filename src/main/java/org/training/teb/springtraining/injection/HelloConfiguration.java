package org.training.teb.springtraining.injection;

import a.b.c.MyOtherBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.training.teb.springtraining.HelloWorld;

@Configuration
public class HelloConfiguration {

    private long counter;

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

    @Scheduled(fixedDelay = 10_000,initialDelay = 1_000)
    public void scheduleTest() {
        System.out.println("Schedule Test : " + counter++);
    }

    @Scheduled(cron = "*/3 * * * * *")
    public void cronScheduleTest() {
        System.out.println("Schedule Cron Test : " + counter++);
    }



}
