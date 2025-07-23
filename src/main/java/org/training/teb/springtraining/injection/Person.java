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
@NoArgsConstructor
public class Person {
    private Long       personId;
    private String     name;
    private String     surname;
    private Integer    weight;
    private Integer    height;
    private BigDecimal amount;

    @Builder(setterPrefix = "with")
    public Person(final Long personIdParam,
                  final String nameParam,
                  final String surnameParam,
                  final Integer weightParam,
                  final Integer heightParam,
                  final BigDecimal amountParam) {
        personId = personIdParam;
        name     = nameParam;
        surname  = surnameParam;
        weight   = weightParam;
        height   = heightParam;
        amount   = amountParam;
    }
}
