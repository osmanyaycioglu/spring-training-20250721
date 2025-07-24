package org.training.teb.springtraining.person.service.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private Long          personId;
    @Column(name = "person_name")
    private String        name;
    @NotBlank
    private String        surname;
    private Integer       weight;
    private Integer       height;
    private BigDecimal    amount;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "person")
    private PersonDetails personDetails;
    @Enumerated(EnumType.STRING)
    @Column(name = "person_status",nullable = false)
    @NotNull
    private EStatus       personStatus = EStatus.ACTIVE;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<PersonPhone> personPhones;

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
