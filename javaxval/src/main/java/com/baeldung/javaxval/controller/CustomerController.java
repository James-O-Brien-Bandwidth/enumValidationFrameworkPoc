package com.baeldung.javaxval.controller;

import com.baeldung.javaxval.InvalidCustomerEnumException;
import com.baeldung.javaxval.enums.demo.Customer;
import com.baeldung.javaxval.enums.demo.CustomerExperimental;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Validated
public class CustomerController {

    @PostMapping()
    public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customer) {

        return null;
    }

    @PostMapping("/1")
    public ResponseEntity<String> createCustomer1(@Valid @RequestBody List<CustomerExperimental> customer) {

        // Sample CURL to use for debugging:
      /*
        curl --location 'http://localhost:8097/api' \
        --header 'Content-Type: application/json' \
        --data '{
        "customerTypeString": "test_c60cf82795eb",
                "customerTypeOfSubset": "DEFAULT",
                "customerTypeMatchesPattern": "DEFAULT"
    }'
    */

        System.out.println(
                "In CustomerController.createPerson() and the details of the customer are: " + customer.toString());

        return ResponseEntity.ok("Customer created successfully");
    }

    @ExceptionHandler(InvalidCustomerEnumException.class)
    public ResponseEntity<String> handleInvalidUserRoleException(InvalidCustomerEnumException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
//    public ResponseEntity<List<String>> handleValidationException(
//            org.springframework.web.bind.MethodArgumentNotValidException ex) {
//        List<String> errors = ex.getBindingResult().getFieldErrors()
//                .stream()
//                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorResponse>> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<ValidationErrorResponse> errorResponses = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            ValidationErrorResponse errorResponse = new ValidationErrorResponse();
            errorResponse.setField(fieldError.getField());
            errorResponse.setDefaultMessage(fieldError.getDefaultMessage());
            errorResponses.add(errorResponse);
        }

        return new ResponseEntity<>(errorResponses, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<List<String>> handleValidationException(HttpMessageNotReadableException ex) {

//        List<String> errors = ex.getBindingResult().getFieldErrors()
//                .stream()
//                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
//                .collect(Collectors.toList());

        return null;
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
