package com.baeldung.javaxval.controller;

import org.springframework.validation.FieldError;

public class ErrorResponseObject {

    private FieldError fieldError;
    private String msg;
    private int errorCount;

    public void SetFieldError(FieldError fieldError) {
        this.fieldError = fieldError;
    }

    public void setDefaultMessage(String msg) {
        this.msg = msg;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }
}
