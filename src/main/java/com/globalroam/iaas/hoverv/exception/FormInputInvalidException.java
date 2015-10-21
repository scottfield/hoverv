package com.globalroam.iaas.hoverv.exception;

import org.springframework.validation.Errors;

/**
 * exception indicates that the form data submit from the end user
 * is not correct according to the rules defined in the validator.
 * Created by chenglong on 2015/10/20.
 */
public class FormInputInvalidException extends RuntimeException {
    private Errors errors;

    public FormInputInvalidException(Errors errors) {
        super();
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
