package org.training.teb.springtraining.person.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.training.teb.springtraining.person.db.PersonDao;
import org.training.teb.springtraining.person.service.models.Person;

@Service
@RequiredArgsConstructor
public class PersonProvisionService {
    private final PersonDao personDao;


    public Long addPerson(Person personParam){
        return personDao.insertPerson(personParam);
    }

}
