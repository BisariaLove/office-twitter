package com.leo.solutions.officetwitter.exception;
/*
 * @author love.bisaria on 23/03/19
 */

import com.leo.solutions.officetwitter.domain.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException ex, HttpServletRequest request){
        log.error("Exception happened: {}", ex.getMessage());
        return resolveException(ex.getMessage(), ex.getHttpCode(), "");

    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorResponse> handleEmptyResultDataAccessException(Exception ex, HttpServletRequest request){
        log.error("Exception happened: {}", ex.getMessage());
        return resolveException("Not Found", 404, "");

    }

    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> unknownException(Exception ex){
        log.error("Exception happened: {}", ex.getMessage());
        return resolveException("Unknown Exception", 500, "");
    }*/

    private ResponseEntity<ErrorResponse> resolveException(String message, int httpCode, String hint) {
        return ResponseEntity.status(httpCode).body(new ErrorResponse(httpCode, message,  hint));
    }
}
