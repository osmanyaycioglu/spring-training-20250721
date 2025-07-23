package org.training.teb.springtraining.person.rest.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonDetailsDto {

    @NotBlank
    @Size(min = 10)
    private String phoneNumber;
    @NotBlank
    private String address;

}
