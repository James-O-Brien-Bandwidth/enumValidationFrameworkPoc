package com.baeldung.javaxval.enums;

import com.baeldung.javaxval.enums.constraints.CustomerTypeSubset1;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerTypeSubSetValidator1 implements ConstraintValidator<CustomerTypeSubset1, String> {
    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(CustomerTypeSubset1 constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Enum<?>[] enumValues = enumClass.getEnumConstants();
        for (Enum<?> enumValue : enumValues) {
            if (enumValue.name().equals(value)) {
                return true;  // Valid enum value
            }
        }
        return false;  // Invalid enum value
    }
}
