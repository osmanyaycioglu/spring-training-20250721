package org.training.teb.springtraining.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorRestController {

    @Autowired
    @Qualifier("add1")
    private Add add1;

    @Autowired
    @Qualifier("add2")
    private Add add2;

    @Autowired
    @Qualifier("add3")
    private Add add3;

    @Autowired
    private Add[] allAdds;


    @GetMapping("/addAll")
    public String addAll(@RequestParam Integer v1,
                         @RequestParam Integer v2) {
        StringBuilder builderLoc = new StringBuilder();
        for (Add allAddLoc : allAdds) {
            builderLoc.append("sonuç ")
                      .append(allAddLoc.getDelta())
                      .append(" : ")
                      .append(allAddLoc.calculate(v1,
                                                  v2));
        }

        return builderLoc.toString();
    }

    @GetMapping("/add1")
    public String add1(@RequestParam Integer v1,
                       @RequestParam Integer v2) {
        return "sonuç : " + add1.calculate(v1,
                                           v2);
    }

    @GetMapping("/add2")
    public String add2(@RequestParam Integer v1,
                       @RequestParam Integer v2) {
        return "sonuç : " + add2.calculate(v1,
                                           v2);
    }

    @GetMapping("/add3")
    public String add3(@RequestParam Integer v1,
                       @RequestParam Integer v2) {
        return "sonuç : " + add3.calculate(v1,
                                           v2);
    }

}
