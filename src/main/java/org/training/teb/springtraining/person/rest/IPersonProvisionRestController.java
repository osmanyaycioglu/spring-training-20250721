package org.training.teb.springtraining.person.rest;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.teb.springtraining.person.rest.models.PersonAddResponse;
import org.training.teb.springtraining.person.rest.models.PersonDto;

public interface IPersonProvisionRestController {

    @Operation(summary = "Yeni kişi ekle", description = "Sisteme yeni kişiyi eklemek için kullanılır")
    PersonAddResponse add(PersonDto personDtoParam);

}

