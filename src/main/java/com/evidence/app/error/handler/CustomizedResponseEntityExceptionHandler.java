package com.evidence.app.error.handler;

import com.evidence.app.util.DateProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author JayendraB
 * @createdOn 5/14/2021
 */
@RestController
@ControllerAdvice
@Slf4j
public class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        log.error("Reason of Exception : {}", String.valueOf(ex.getMessage()));
        log.error("Occurred at : {}", ex.getStackTrace());
        ExceptionResponse response = new ExceptionResponse(DateProcessor.toDate(DateProcessor.getCurrentDateAndTime()),HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public final ResponseEntity<Object> handleNoResultException(NoHandlerFoundException ex, WebRequest request) {
        log.error("Exception : {} ", ex.getCause());
        log.error(String.valueOf(ex));
        ExceptionResponse response = new ExceptionResponse(DateProcessor.toDate(DateProcessor.getCurrentDateAndTime()),HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.toString(), "No message available",request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotImplementedException.class)
    public final ResponseEntity<Object> handleNoImplementException(NotImplementedException ex, WebRequest request) {
        log.error("Exception : {} ", ex.getCause());
        log.error(String.valueOf(ex));
        ExceptionResponse response = new ExceptionResponse(DateProcessor.toDate(DateProcessor.getCurrentDateAndTime()),HttpStatus.NOT_FOUND.value(),"Not implemented", ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
