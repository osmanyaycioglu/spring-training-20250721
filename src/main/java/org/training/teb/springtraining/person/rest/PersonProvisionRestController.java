package org.training.teb.springtraining.person.rest;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.teb.springtraining.person.rest.models.PersonAddResponse;
import org.training.teb.springtraining.person.rest.models.PersonDto;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionRestController implements IPersonProvisionRestController {

    @PostMapping("/add")
    public PersonAddResponse add(@Valid @RequestBody PersonDto personDtoParam) {
        return new PersonAddResponse("basarili",
                                     12L);
    }

    @PostMapping("/add2")
    public ResponseEntity<PersonAddResponse> add2(@Valid @RequestBody PersonDto personDtoParam) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                             .body(new PersonAddResponse("basarili",
                                                         12L));
    }

}

