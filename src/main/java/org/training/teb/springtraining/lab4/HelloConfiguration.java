package org.training.teb.springtraining.lab4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration("helloConf")
public class HelloConfiguration {

//    @Bean
//    public IHello helloEng() {
//        return new HelloEng();
//    }
//
//    @Bean
//    public IHello helloTr() {
//        return new HelloTr();
//    }

    @Bean
    public IHello helloDynamicOld(@Value("${app.language}") String language) {
        switch (language) {
            case "eng":
                return new HelloEng();
            case "tr":
                return new HelloTr();
            case "esp":
                return new HelloEsp();
            default:
                return new HelloEng();
        }
    }

//    @Bean
//    public IHello helloDynamic(IHello[] allHellos,
//                               @Value("${app.language}") String language) {
//        for (IHello allHelloLoc : allHellos) {
//            if (language.equals(allHelloLoc.languageIndex())){
//                return allHelloLoc;
//            }
//        }
//        return new HelloEng();
//    }

    @Bean
    public IHello helloDynamic(Map<String,IHello> allHellos,
                               @Value("${app.language}") String language) {
        System.out.println(allHellos);
        for (IHello allHelloLoc : allHellos.values()) {
            if (language.equals(allHelloLoc.languageIndex())){
                return allHelloLoc;
            }
        }
        return new HelloEng();
    }

}
