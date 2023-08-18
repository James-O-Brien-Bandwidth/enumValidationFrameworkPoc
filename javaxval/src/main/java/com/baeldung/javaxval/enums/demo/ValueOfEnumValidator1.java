package com.baeldung.javaxval.enums.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValueOfEnumValidator1 implements ConstraintValidator<ValueOfEnum1, CharSequence> {

    private List<String> acceptedValues;

    @Override
    public void initialize(ValueOfEnum1 annotation) {
        acceptedValues = Stream.of(annotation.enumClass()
                        .getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return acceptedValues.contains(value.toString());
    }
}
