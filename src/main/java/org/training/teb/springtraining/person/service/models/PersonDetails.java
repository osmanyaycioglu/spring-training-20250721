package org.training.teb.springtraining.person.service.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class PersonDetails {
    @Id
    @GeneratedValue
    private Long personDetailsId;
    private String phoneNumber;
    private String address;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "person_id")
    private Person person;

}
