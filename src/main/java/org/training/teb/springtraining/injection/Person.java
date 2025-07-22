package org.training.teb.springtraining.injection;

import lombok.*;

import java.math.BigDecimal;

//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class Person {
    private Long       personId;
    private String     name;
    private String     surname;
    private Integer    weight;
    private Integer    height;
    private BigDecimal amount;

}
