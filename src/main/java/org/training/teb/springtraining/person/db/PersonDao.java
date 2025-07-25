package org.training.teb.springtraining.person.db;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.training.teb.springtraining.person.db.repositories.IDbCounterRepository;
import org.training.teb.springtraining.person.db.repositories.IPersonRepository;
import org.training.teb.springtraining.person.rest.models.PersonDto;
import org.training.teb.springtraining.person.service.models.DbCounter;
import org.training.teb.springtraining.person.service.models.Person;
import org.training.teb.springtraining.person.service.models.PersonDetails;
import org.training.teb.springtraining.person.service.models.PersonPhone;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PersonDao {
    private final IPersonRepository personRepository;
    private final IDbCounterRepository dbCounterRepository;
    private long counter = 10;

    public Long insertPerson(Person personParam){
        PersonDetails personDetailsLoc = personParam.getPersonDetails();
        if (personDetailsLoc != null && personDetailsLoc.getPerson() == null){
            personDetailsLoc.setPerson(personParam);
        }
        Set<PersonPhone> personPhonesLoc = personParam.getPersonPhones();
        if (personPhonesLoc != null){
            personPhonesLoc.forEach(p -> p.setPerson(personParam));
        }
        personRepository.save(personParam);
        return personParam.getPersonId();
    }

    public List<Person> findByName(final String nameParam) {
        return personRepository.findByName(nameParam);
    }

    @Transactional(propagation = Propagation.REQUIRED )
    public Long insertPerson2(Person personParam){
        counter++;
        PersonDetails personDetailsLoc = personParam.getPersonDetails();
        if (personDetailsLoc != null && personDetailsLoc.getPerson() == null){
            personDetailsLoc.setPerson(personParam);
        }
        Set<PersonPhone> personPhonesLoc = personParam.getPersonPhones();
        if (personPhonesLoc != null){
            personPhonesLoc.forEach(p -> p.setPerson(personParam));
        }
        personRepository.save(personParam);
        DbCounter dbCounterLoc = new DbCounter(null, "personInsertCount", counter);
        dbCounterRepository.save(dbCounterLoc);
        System.out.println("another code");
        return personParam.getPersonId();
    }

    @Transactional(propagation = Propagation.REQUIRED )
    public Long insertPerson3(Person personParam){
        Long lLoc = insertPerson2a(personParam);
        insertCounter();
        return lLoc;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Long insertPerson2a(Person personParam){
        counter++;
        PersonDetails personDetailsLoc = personParam.getPersonDetails();
        if (personDetailsLoc != null && personDetailsLoc.getPerson() == null){
            personDetailsLoc.setPerson(personParam);
        }
        Set<PersonPhone> personPhonesLoc = personParam.getPersonPhones();
        if (personPhonesLoc != null){
            personPhonesLoc.forEach(p -> p.setPerson(personParam));
        }
        personRepository.save(personParam);
        return personParam.getPersonId();
    }

    @Transactional(propagation = Propagation.REQUIRED,noRollbackFor = {IllegalStateException.class},isolation = Isolation.READ_COMMITTED)
    public void insertCounter(){
        DbCounter dbCounterLoc = new DbCounter(null, "personInsertCount", counter);
        dbCounterRepository.save(dbCounterLoc);
        System.out.println("another code");
    }

}
