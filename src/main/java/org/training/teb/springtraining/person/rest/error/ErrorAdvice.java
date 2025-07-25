package org.training.teb.springtraining.person.rest.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ErrorAdvice.class);

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withErrorDescriptionParam(exp.getMessage())
                       .withErrorCodeParam(1005)
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(MethodArgumentNotValidException exp) {
        return ErrorObj.builder()
                       .withErrorDescriptionParam("Validation Error")
                       .withErrorCodeParam(2001)
                       .withSubErrorObjsParam(exp.getAllErrors()
                                                 .stream()
                                                 .map(se -> ErrorObj.builder()
                                                                    .withErrorDescriptionParam(se.toString())
                                                                    .withErrorCodeParam(1006)
                                                                    .build())
                                                 .collect(Collectors.toList()))
                       .build();


    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handle(Exception exp) {
        logger.error("[ErrorAdvice][handle]-> *Error* : " + exp.getMessage(),
                     exp);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .header("error",
                                     "yanlış kodlama")
                             .body(
                                     ErrorObj.builder()
                                             .withErrorDescriptionParam(exp.getMessage())
                                             .withErrorCodeParam(5000)
                                             .build());
    }

}
