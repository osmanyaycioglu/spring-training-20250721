package org.training.teb.springtraining.injection;

import org.springframework.stereotype.Service;
import org.training.teb.springtraining.person.service.models.Person;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PersonCacheService {
    private Map<Long, Person> personMap = new ConcurrentHashMap<>();

    public PersonCacheService() {
        personMap.put(1L,
                      Person.builder()
                            .personId(1L)
                            .name("osman")
                            .surname("yaycıoğlu")
                            .weight(90)
                            .height(200)
                            .amount(new BigDecimal(1000))
                            .build());

        personMap.put(2L,
                      Person.builder()
                            .personId(2L)
                            .name("ali")
                            .surname("veli")
                            .weight(90)
                            .height(200)
                            .amount(new BigDecimal(1000))
                            .build());

    }

    public Person getPerson(Long personId) {
        return personMap.get(personId);
    }
}
