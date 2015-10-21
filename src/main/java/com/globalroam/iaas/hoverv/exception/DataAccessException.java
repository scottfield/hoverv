package com.globalroam.iaas.hoverv.exception;

/**
 * Class description :the base exception of data access tier indicates that
 * there are something wrong with accessing data from db or somewhere else.
 *
 * @author :  guangliang
 * @version : 1.0
 * @date �� 15/10/20
 */
public class DataAccessException extends RuntimeException {
    /**
     * the message display to the end user,so try to make it easy to
     * understand
     */
    private Object message;
    private int statusCode;
    private String code;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public DataAccessException() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public Object getCustomMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

