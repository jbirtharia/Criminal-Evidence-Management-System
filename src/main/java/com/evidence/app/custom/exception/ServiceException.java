package com.evidence.app.custom.exception;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public class ServiceException extends  RuntimeException{

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
