package org.training.teb.springtraining.person.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.teb.springtraining.person.mappers.IPersonMapper;
import org.training.teb.springtraining.person.rest.models.PersonAddResponse;
import org.training.teb.springtraining.person.rest.models.PersonDto;
import org.training.teb.springtraining.person.service.PersonProvisionService;
import org.training.teb.springtraining.person.service.PersonQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person/query")
@RequiredArgsConstructor
public class PersonQueryRestController {
    private final PersonQueryService personQueryService;

    @GetMapping("/find/by/name")
    public List<PersonDto> findByName(@RequestParam String name) {
        return IPersonMapper.PERSON_MAPPER.toPersonDtos(personQueryService.findByName(name));
    }


}

