package org.training.teb.springtraining.injection;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WithdrawProcess implements IProcess {
    @Override
    public String execute(final Person personParam,
                          final BigDecimal amount) {
        personParam.setAmount(personParam.getAmount()
                                         .subtract(amount));
        return "Kalan bakiye : " + personParam.getAmount();
    }

    @Override
    public String processName() {
        return "withdraw";
    }
}
