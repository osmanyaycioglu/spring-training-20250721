package org.training.teb.springtraining.person.service.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonDetails {
    private String phoneNumber;
    private String address;

}
