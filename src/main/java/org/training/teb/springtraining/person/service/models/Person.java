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
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "person")
@SequenceGenerator(name = "person_sq", sequenceName = "person_sq", initialValue = 1, allocationSize = 100)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sq")
    private Long       personId;
    @Column(name = "person_name")
    private String     name;
    @NotBlank
    private String     surname;
    private Integer    weight;
    private Integer    height;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    private PersonDetails personDetails;
    @Enumerated(EnumType.STRING)
    @Column(name = "person_status", nullable = false)
    @NotNull
    private EStatus       personStatus = EStatus.ACTIVE;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    private Set<PersonPhone> personPhones;

    @Version
    private Long personVersion;

    @Builder
    public Person(final Long personId,
                  final String name,
                  final String surname,
                  final Integer weight,
                  final Integer height,
                  final BigDecimal amount,
                  final PersonDetails personDetails,
                  final Set<PersonPhone> personPhones) {
        this.personId      = personId;
        this.name          = name;
        this.surname       = surname;
        this.weight        = weight;
        this.height        = height;
        this.amount        = amount;
        this.personDetails = personDetails;
        this.personPhones  = personPhones;
    }

    @Override
    public String toString() {
        return "Person{" +
               "personId=" + personId +
               ", name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", weight=" + weight +
               ", height=" + height +
               ", amount=" + amount +
               ", personDetails=" + personDetails +
               ", personStatus=" + personStatus +
               ", personPhones=" + personPhones +
               '}';
    }
}
