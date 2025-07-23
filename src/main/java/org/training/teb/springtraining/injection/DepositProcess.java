package org.training.teb.springtraining.injection;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DepositProcess implements IProcess {
    @Override
    public String execute(final Person personParam,
                          final BigDecimal amount) {
        personParam.setAmount(personParam.getAmount()
                                         .add(amount));
        return "Bakiye : " + personParam.getAmount();
    }

    @Override
    public String processName() {
        return "deposit";
    }
}
