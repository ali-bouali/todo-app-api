package com.bouali.todo.exception;


public enum ErrorCodes {
    USER_NOT_FOUND(1000),
    CATEGORY_NOT_FOUND(1001),
    TODO_NOT_FOUND(1002),
    USER_NOT_VALID(2000),
    CATEGORY_NOT_VALID(2001),
    TODO_NOT_VALID(2002),
    ;

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}