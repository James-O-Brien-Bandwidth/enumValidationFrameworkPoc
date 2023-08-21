package com.baeldung.javaxval.enums.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValueOfEnumValidator1 implements ConstraintValidator<EnumConstraint, CharSequence> {

    private List<String> acceptedValues;

    @Override
    public void initialize(EnumConstraint annotation) {
        acceptedValues = Stream.of(annotation.enumClass()
                        .getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());

        acceptedValues.remove("IN_PROGRESS");
        acceptedValues.remove("CLOSED");
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        // IN_SERVICE_BW and AVAILABLE only allowed

        return !(value.equals(CustomerType.NEW.toString()) || value.equals(CustomerType.OLD.toString()));
    }
}
