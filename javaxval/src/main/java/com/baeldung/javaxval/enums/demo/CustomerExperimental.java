package com.baeldung.javaxval.enums.demo;

public class CustomerExperimental {

    @ValueOfEnum1(enumClass = CustomerType.class)
    private String customerTypeString;

    public CustomerExperimental() {
    }

    public CustomerExperimental(String customerTypeString) {
        this.customerTypeString = customerTypeString;
    }

    public String getCustomerTypeString() {
        return customerTypeString;
    }

    public void setCustomerTypeString(String customerTypeString) {
        this.customerTypeString = customerTypeString;
    }

}
