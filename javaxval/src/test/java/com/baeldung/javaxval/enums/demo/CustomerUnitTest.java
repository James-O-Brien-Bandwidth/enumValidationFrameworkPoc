package com.baeldung.javaxval.enums.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import java.util.function.Predicate;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.baeldung.javaxval.LocaleAwareUnitTest;

public class CustomerUnitTest extends LocaleAwareUnitTest {

    private static Validator validator;

    @BeforeClass
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory()
            .getValidator();
    }

    @Test
    public void whenAllAcceptable_thenShouldNotGiveConstraintViolations() {
        Customer customer = new Customer();
        customer.setCustomerTypeOfSubset(CustomerType.NEW);
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertThat(violations).isEmpty();
    }

    @Test
    public void whenAllNull_thenOnlyNotNullShouldGiveConstraintViolations() {
        Customer customer = new Customer();
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertThat(violations.size()).isEqualTo(1);

        assertThat(violations).anyMatch(havingPropertyPath("customerTypeOfSubset").and(havingMessage("must not be null")));
    }

    @Test
    public void whenAllInvalid_thenViolationsShouldBeReported() {
        Customer customer = new Customer();
        customer.setCustomerTypeString("invalid");
        customer.setCustomerTypeOfSubset(CustomerType.DEFAULT);
        customer.setCustomerTypeMatchesPattern(CustomerType.OLD);

        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertThat(violations.size()).isEqualTo(3);

        assertThat(violations).anyMatch(havingPropertyPath("customerTypeString").and(havingMessage("must be any of enum class com.baeldung.javaxval.enums.demo.CustomerType")));
        assertThat(violations).anyMatch(havingPropertyPath("customerTypeOfSubset").and(havingMessage("must be any of [NEW, OLD]")));
        assertThat(violations).anyMatch(havingPropertyPath("customerTypeMatchesPattern").and(havingMessage("must match \"NEW|DEFAULT\"")));
    }

    public static Predicate<ConstraintViolation<Customer>> havingMessage(String message) {
        return l -> message.equals(l.getMessage());
    }

    public static Predicate<ConstraintViolation<Customer>> havingPropertyPath(String propertyPath) {
        return l -> propertyPath.equals(l.getPropertyPath()
            .toString());
    }

    //   Test 4 - enum value could be "INVALID"
    @Test
    public void whenCustomerIsTotallyINVALID_thenViolationConstraintShouldBeThrown() {
        Customer customer = new Customer();
        customer.setCustomerTypeString("invalid");
//        customer.setCustomerTypeOfSubset("asdas");
        customer.setCustomerTypeMatchesPattern(CustomerType.OLD);

        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertThat(violations.size()).isEqualTo(3);

        assertThat(violations).anyMatch(havingPropertyPath("customerTypeString").and(havingMessage("must be any of enum class com.baeldung.javaxval.enums.demo.CustomerType")));
        assertThat(violations).anyMatch(havingPropertyPath("customerTypeOfSubset").and(havingMessage("must be any of [NEW, OLD]")));
        assertThat(violations).anyMatch(havingPropertyPath("customerTypeMatchesPattern").and(havingMessage("must match \"NEW|DEFAULT\"")));
    }


    // Step 1. Write out test scenarios for me assert against
    // Step 2. Make the module a SpringBootApp so I can manually test
    // Step 3. Convert the tests of step 1 to MVC tests so I can pass in any test-data input

}
