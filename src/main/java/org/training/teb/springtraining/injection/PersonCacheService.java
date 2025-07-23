package org.training.teb.springtraining.injection;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PersonCacheService {
    private Map<Long, Person> personMap = new ConcurrentHashMap<>();

    public PersonCacheService() {
        personMap.put(1L,
                      Person.builder()
                            .withPersonIdParam(1L)
                            .withNameParam("osman")
                            .withSurnameParam("yaycıoğlu")
                            .withWeightParam(90)
                            .withHeightParam(200)
                            .withAmountParam(new BigDecimal(1000))
                            .build());
        personMap.put(2L,
                      Person.builder()
                            .withPersonIdParam(2L)
                            .withNameParam("ali")
                            .withSurnameParam("veli")
                            .withWeightParam(80)
                            .withHeightParam(180)
                            .withAmountParam(new BigDecimal(3000))
                            .build());
        personMap.put(3L,
                      Person.builder()
                            .withPersonIdParam(3L)
                            .withNameParam("mehmet")
                            .withSurnameParam("alaz")
                            .withWeightParam(70)
                            .withHeightParam(160)
                            .withAmountParam(new BigDecimal(5000))
                            .build());

    }

    public Person getPerson(Long personId) {
        return personMap.get(personId);
    }
}
