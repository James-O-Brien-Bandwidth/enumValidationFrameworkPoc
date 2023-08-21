package com.baeldung.javaxval.controller;


import com.baeldung.javaxval.enums.demo.CustomerType;

public class CustomerInfo {
    private CustomerType customerType;
    private String firstName;
    private String lastName;

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
