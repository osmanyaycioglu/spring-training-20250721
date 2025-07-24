package org.training.teb.springtraining.person.service.models;

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
    private Long          personId;
    private String        name;
    private String        surname;
    private Integer       weight;
    private Integer       height;
    private BigDecimal    amount;
    private PersonDetails personDetails;
    private EStatus       personStatus;

    @Builder
    public Person(final Long personId,
                  final String name,
                  final String surname,
                  final Integer weight,
                  final Integer height,
                  final BigDecimal amount,
                  final PersonDetails personDetails) {
        this.personId      = personId;
        this.name          = name;
        this.surname       = surname;
        this.weight        = weight;
        this.height        = height;
        this.amount        = amount;
        this.personDetails = personDetails;
    }
}
