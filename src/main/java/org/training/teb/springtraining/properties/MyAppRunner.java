package org.training.teb.springtraining.properties;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyAppRunner implements ApplicationRunner {
    private final MyProps myProps;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        System.out.println("Props : " + myProps);
    }

}
