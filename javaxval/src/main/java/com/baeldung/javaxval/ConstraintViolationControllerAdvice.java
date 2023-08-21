package com.baeldung.javaxval;

import com.baeldung.javaxval.controller.ValidationErrorResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ConstraintViolationControllerAdvice {

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        System.out.println("Binder initialization ... " + binder);
////        binder.setBindValidationErrors(true);
//    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("Global binder initializer");
        // Customize data binding and validation rules here
        // For example, you can register custom property editors or validators
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse handleConstraintViolationException(
            ConstraintViolationException ex,
            BindingResult bindingResult) {

        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

        List<ValidationError> errors = constraintViolations.stream()
                .map(this::mapConstraintViolationToError)
                .collect(Collectors.toList());

        return new ValidationErrorResponse(errors);
    }

    private ValidationError mapConstraintViolationToError(ConstraintViolation<?> violation) {
        return new ValidationError(
                violation.getPropertyPath().toString(),
                violation.getMessage()
        );
    }
}
