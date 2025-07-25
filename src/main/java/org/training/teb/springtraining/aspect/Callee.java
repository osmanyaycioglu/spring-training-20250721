package org.training.teb.springtraining.aspect;

import org.springframework.stereotype.Component;

@Component
public class Callee {

    public String callMe(String name){
        return "Beni çağırdın : " + name;
    }

}
