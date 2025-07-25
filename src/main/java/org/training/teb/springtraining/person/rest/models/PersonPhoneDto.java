package org.training.teb.springtraining.person.rest.models;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PersonPhoneDto {

    @NotBlank
    private String phoneName;
    @NotBlank
    @Pattern(regexp = "^[0-9]*$")
    private String phoneNumber;

}
