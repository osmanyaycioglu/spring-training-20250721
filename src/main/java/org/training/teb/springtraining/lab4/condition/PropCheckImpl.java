package org.training.teb.springtraining.lab4.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

public class PropCheckImpl implements Condition {
    @Override
    public boolean matches(final ConditionContext context,
                           final AnnotatedTypeMetadata metadata) {
        MergedAnnotation<CheckProperty> c = metadata.getAnnotations()
                                                    .get(CheckProperty.class);
        Map<String, Object>           cp = c.asMap();
        String prop = (String) cp.get("prop");
        String val = (String) cp.get("val");
        Environment environmentLoc = context.getEnvironment();
        String      propertyLoc    = environmentLoc.getProperty(prop);
        if (propertyLoc != null && !propertyLoc.isEmpty()){
            if (propertyLoc.equals(val)){
                return true;
            }
        }
        return false;
    }
}
