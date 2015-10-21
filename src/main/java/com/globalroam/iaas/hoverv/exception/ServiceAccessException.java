package com.globalroam.iaas.hoverv.exception;

/**
 * the base exception indicates that service access error.
 * this exception and it's sub type should be only apply to
 * service tier code for clarity.
 * Created by chenglong on 2015/10/20.
 */
public class ServiceAccessException extends RuntimeException {
    /**
     * the error message display for end user,so try to make it
     * as simple as possible.
     */
    private Object errorMessage;

    public ServiceAccessException() {
        super();
    }

    public ServiceAccessException(String message, Throwable cause) {
        super(cause);
        this.errorMessage = message;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }
}
