package com.baeldung.javaxval.controller;

import java.beans.PropertyEditor;


import com.baeldung.javaxval.enums.demo.CustomerType;
import java.beans.PropertyEditorSupport;

public class CustomerTypeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(CustomerType.valueOf(text.toUpperCase()));
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid CustomerType value: " + text);
        }
    }
}
