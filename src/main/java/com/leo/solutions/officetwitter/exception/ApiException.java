package com.leo.solutions.officetwitter.exception;
/*
 * @author love.bisaria on 23/03/19
 */

public class ApiException extends RuntimeException{

    private String message;
    private int httpCode;

    public ApiException(String message, int httpStatusCode) {
        super(message);
        this.message =  message;
        this.httpCode = httpStatusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }
}
