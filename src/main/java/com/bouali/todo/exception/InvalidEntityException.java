package com.bouali.todo.exception;

import java.util.List;

public class InvalidEntityException extends RuntimeException {

    private ErrorCodes errorCode;
    private List<String> errors;

    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCode, List<String> errors) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public InvalidEntityException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, ErrorCodes errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }

    public List<String> getErrors() { return errors; }
}
