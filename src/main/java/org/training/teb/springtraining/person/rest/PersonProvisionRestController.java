package org.training.teb.springtraining.person.rest;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.teb.springtraining.person.mappers.IPersonMapper;
import org.training.teb.springtraining.person.rest.models.PersonAddResponse;
import org.training.teb.springtraining.person.rest.models.PersonDto;
import org.training.teb.springtraining.person.service.PersonProvisionService;

@RestController
@RequestMapping("/api/v1/person/provision")
@RequiredArgsConstructor
public class PersonProvisionRestController implements IPersonProvisionRestController {
    private final PersonProvisionService personProvisionService;

    @PostMapping("/add")
    public PersonAddResponse add(@Valid @RequestBody PersonDto personDtoParam) {
        personProvisionService.addPerson(IPersonMapper.PERSON_MAPPER.toPerson(personDtoParam));

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

