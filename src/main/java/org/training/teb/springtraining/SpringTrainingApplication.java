package org.training.teb.springtraining;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication(scanBasePackages = {"org.training.teb",
                                           "a.b.c"
})
@EnableScheduling
@EnableAsync
public class SpringTrainingApplication {
    // Field Injection
    @Autowired
    private HelloWorld helloWorld;
    @Autowired
    @Qualifier("myHello")
    private HelloWorld helloWorld2;
    @Autowired
    @Qualifier("haName")
    private HelloWorld helloWorld3;
    @Autowired
    private HelloWorld helloWorld4;


    private HelloWorld helloWorld5;


    private HelloWorld helloWorld6;

    // Constructor Injection
    // @Autowired
    public SpringTrainingApplication(@Qualifier("anotherHello") final HelloWorld helloWorld5Param) {
        helloWorld5 = helloWorld5Param;
    }


    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    // method injection
    @Autowired
    public void creatMe(HelloWorld worldParam) {
        helloWorld6 = worldParam;
    }

//    public SpringTrainingApplication() {
//        System.out.println("SpringTrainingApplication created");
//    }

    public static void main(String[] args) {
        ConfigurableApplicationContext contextLoc = SpringApplication.run(SpringTrainingApplication.class,
                                                                          args);
        SpringTrainingApplication beanLoc = contextLoc.getBean(SpringTrainingApplication.class);
        System.out.println(beanLoc.helloWorld.hello("osman1"));
        System.out.println(beanLoc.helloWorld2.hello("osman2"));
        System.out.println(beanLoc.helloWorld3.hello("osman1"));
        System.out.println(beanLoc.helloWorld4.hello("osman1"));
        Future<String> stringFutureLoc = beanLoc.helloWorld4.asyncHello("osman3");
        System.out.println("another code");
        try {
            boolean doneLoc  = stringFutureLoc.isDone();
            String stringLoc = stringFutureLoc.get();
        } catch (Exception eParam) {
            eParam.printStackTrace();
        }

        //        HelloWorld helloWorldLoc = new HelloWorld();
        //        String     helloLoc      = helloWorldLoc.hello("osman");
        //        System.out.println("Hello sonuç : " + helloLoc);


    }

}
