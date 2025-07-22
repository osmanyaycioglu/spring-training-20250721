package org.training.teb.springtraining.lab3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Subs {
    private Integer delta;


    public Integer calculate(Integer v1,Integer v2){
        return v1 - v2 - delta;
    }
}
