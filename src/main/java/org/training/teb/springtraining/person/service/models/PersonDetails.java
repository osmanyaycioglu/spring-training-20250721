package org.training.teb.springtraining.person.service.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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

}
