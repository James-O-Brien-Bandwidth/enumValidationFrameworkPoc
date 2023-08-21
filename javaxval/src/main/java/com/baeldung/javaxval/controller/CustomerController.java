package com.baeldung.javaxval.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Validated
public class CustomerController {

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(CustomerType.class, new CustomerTypeEditor());
//    }

    /*

    Example of a CURL to use when an invalid ENUM valid is supplied:
    curl --location 'http://localhost:8099/api/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "test_53fbb027ef71",
    "email": "jobrien@bandwidth.com",
    "age": 30,
    "customerTypeString": "asdasd"
}'

     */

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Validated UserRegistration userRegistration,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            System.out.println("Error encountered: " + bindingResult.getFieldError().getDefaultMessage());
            return ResponseEntity.badRequest()
                    .body("Invalid input: " + bindingResult.getFieldError().getDefaultMessage());
        }

        // Your code to process user registration

        return ResponseEntity.ok("User registered successfully");
    }

}
