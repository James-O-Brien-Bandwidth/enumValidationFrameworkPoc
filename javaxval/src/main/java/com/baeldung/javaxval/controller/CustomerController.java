package com.baeldung.javaxval.controller;

import com.baeldung.javaxval.enums.demo.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class CustomerController {

    @PostMapping
    public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customer) {

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

        return ResponseEntity.ok("Person created successfully");
    }

}
