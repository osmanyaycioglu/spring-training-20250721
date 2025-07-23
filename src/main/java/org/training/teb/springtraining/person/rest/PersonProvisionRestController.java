package org.training.teb.springtraining.person.rest;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.training.teb.springtraining.injection.Person;
import org.training.teb.springtraining.person.rest.models.PersonAddResponse;
import org.training.teb.springtraining.person.rest.models.PersonDto;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionRestController {

    @PostMapping("/add")
    public PersonAddResponse add(@Valid @RequestBody PersonDto personDtoParam) {
        return new PersonAddResponse("basarili",12L);
    }

}

