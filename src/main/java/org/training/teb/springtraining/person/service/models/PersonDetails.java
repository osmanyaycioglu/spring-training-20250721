package org.training.teb.springtraining.person.service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@Entity
@ToString(exclude = "person")
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

