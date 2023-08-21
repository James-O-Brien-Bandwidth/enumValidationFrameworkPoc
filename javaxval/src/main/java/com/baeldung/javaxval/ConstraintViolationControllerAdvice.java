package com.baeldung.javaxval;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class ConstraintViolationControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("Global binder initializer");
        // Customize data binding and validation rules here
        // For example, you can register custom property editors or validators
    }

}
