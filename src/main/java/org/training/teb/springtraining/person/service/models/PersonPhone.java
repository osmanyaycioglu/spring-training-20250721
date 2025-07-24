package org.training.teb.springtraining.person.service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PersonPhone {
    @Id
    @GeneratedValue
    private Long personPhoneId;
    private String phoneName;
    private String phoneNumber;
}
