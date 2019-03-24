package com.leo.solutions.officetwitter.domain;
/*
 * @author love.bisaria on 23/03/19
 */

public class ErrorResponse {

    private int statusCode;
    private String message;
    private String hint;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public ErrorResponse(int statusCode, String message, String hint) {
        this.statusCode = statusCode;
        this.message = message;
        this.hint = hint;
    }
}
