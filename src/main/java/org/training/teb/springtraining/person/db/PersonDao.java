package org.training.teb.springtraining.person.db;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.training.teb.springtraining.person.db.repositories.IPersonRepository;
import org.training.teb.springtraining.person.service.models.Person;
import org.training.teb.springtraining.person.service.models.PersonDetails;

@Service
@RequiredArgsConstructor
public class PersonDao {
    private final IPersonRepository personRepository;

    public Long insertPerson(Person personParam){
        PersonDetails personDetailsLoc = personParam.getPersonDetails();
        if (personDetailsLoc != null && personDetailsLoc.getPerson() == null){
            personDetailsLoc.setPerson(personParam);
        }
        personRepository.save(personParam);
        return personParam.getPersonId();
    }
}
