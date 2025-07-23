package org.training.teb.springtraining.lab4.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Conditional(PropCheckImpl.class)
public @interface CheckProperty {
    String prop();
    String val();
}
