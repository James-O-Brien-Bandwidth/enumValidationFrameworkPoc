package com.baeldung.javaxval.controller;

import com.baeldung.javaxval.ValidationError;
import java.util.List;

public class ValidationErrorResponse {

    private String field;

    public ValidationErrorResponse(List<ValidationError> errors) {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    private String defaultMessage;

}
