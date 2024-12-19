package com.pollsAPI.polls.dto.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class ValidationError {

    private String code;
    private String message;


    @Autowired
    MessageSource messageSource;


    public ValidationError() {}

    public ValidationError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
