package org.training.teb.springtraining.injection;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/bank/money/operations")
@RequiredArgsConstructor
public class BankMoneyOperationsRestController {
    private final PersonCacheService personCacheService;

    @Autowired
    private IProcess[] process;

    @GetMapping("/get/all")
    public String getAll() {
        StringBuilder builderLoc = new StringBuilder();
        int           in         = 1;
        for (IProcess processLoc : process) {
            builderLoc.append(in)
                      .append("-")
                      .append(processLoc.processName())
                      .append("\n");
            in++;
        }
        return builderLoc.toString();
    }

    @GetMapping("/operation/{opId}")
    public String executeOp(@PathVariable int opId,
                          @RequestParam Long personId                              ,
                          @RequestParam BigDecimal amount) {
        Person personLoc = personCacheService.getPerson(personId);
        return process[opId - 1].execute(personLoc,amount);
    }
}

