package com.baeldung.javaxval.controller;

import com.baeldung.javaxval.enums.demo.CustomerType;
import com.baeldung.javaxval.enums.demo.ValueOfEnum1;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class UserRegistration {
    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @ValueOfEnum1(enumClass = CustomerType.class)
    private String customerTypeString;

    public String getCustomerTypeString() {
        return customerTypeString;
    }

    public void setCustomerTypeString(String customerTypeString) {
        this.customerTypeString = customerTypeString;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
