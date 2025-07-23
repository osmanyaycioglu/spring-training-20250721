package org.training.teb.springtraining.person.rest.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PersonDto {
    @NotBlank(message = "Boş olamaz")
    @Size(min = 2,max = 16)
    private String     name;
    @NotEmpty
    private String     surname;
    @NotNull
    @Max(500)
    @Min(10)
    private Integer    weight;
    @NotNull
    @Max(300)
    @Min(50)
    private Integer    height;
    @DecimalMax("15000000.15")
    private BigDecimal amount;

    @Valid
    @NotNull
    private PersonDetailsDto personDetails;
}
