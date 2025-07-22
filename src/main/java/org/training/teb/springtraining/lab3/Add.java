package org.training.teb.springtraining.lab3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Add {
    @Getter
    private Integer delta;


    public Integer calculate(Integer v1,Integer v2){
        return v1 + v2 + delta;
    }
}
