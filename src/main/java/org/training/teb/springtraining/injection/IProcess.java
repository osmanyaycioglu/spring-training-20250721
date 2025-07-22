package org.training.teb.springtraining.injection;

import java.math.BigDecimal;

public interface IProcess {
    String execute(Person personParam,
                   BigDecimal amount);
    String processName();
}
