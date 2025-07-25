package org.training.teb.springtraining.person.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.training.teb.springtraining.person.db.PersonDao;
import org.training.teb.springtraining.person.rest.models.PersonDto;
import org.training.teb.springtraining.person.service.models.Person;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonQueryService {
    private final PersonDao personDao;

    public List<Person> findByName(final String nameParam) {
        return personDao.findByName(nameParam);
    }
}
