package org.training.teb.springtraining.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("method-trace")
@Aspect
@Component
public class MyAspect {
    private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);


    @Around("execution(* org.training.teb.springtraining.aspect.Callee.*(..))")
    public Object enforce(ProceedingJoinPoint pointParam) {

        try {
            Object[] argsLoc   = pointParam.getArgs();
            String   stringLoc = (String) argsLoc[0];
            if (stringLoc.equals("osman")) {
                return "sen burayı çağıramazsın";
            }
            Object proceedLoc = pointParam.proceed();

            return "" + proceedLoc + " değiştirildi";

        } catch (Throwable exp) {
            logger.error("[MyAspect][enforce]-> *Error* : " + exp.getMessage(),
                         exp);
        }

        return "Deneme";

    }

    @Around("@annotation(logDeltaParam)")
    public Object enforce(ProceedingJoinPoint pointParam,
                          LogDelta logDeltaParam) {
        try {
            long   delta      = System.nanoTime();
            Object proceedLoc = pointParam.proceed();
            if (logger.isInfoEnabled()) {
                logger.info(logDeltaParam.prefix()
                            + " -> Delta for : "
                            + pointParam.toShortString()
                            + " : "
                            + (System.nanoTime() - delta));
            }

            return proceedLoc;

        } catch (Throwable exp) {
            logger.error("[MyAspect][enforce]-> *Error* : " + exp.getMessage(),
                         exp);
        }
        return null;
    }

}
