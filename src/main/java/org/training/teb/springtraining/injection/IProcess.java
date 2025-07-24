package org.training.teb.springtraining.injection;

import org.training.teb.springtraining.person.service.models.Person;

import java.math.BigDecimal;

public interface IProcess {
    String execute(Person personParam,
                   BigDecimal amount);
    String processName();
}
