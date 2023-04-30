package com.ltp.contacts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ltp.contacts.exception.ContactNotFoundException;
import com.ltp.contacts.exception.ErrorResponse;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    
    //handles bad Request using invalid id, missing fields
    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<Object> handleContactNotFoundException(ContactNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);

    }

    // handles in validated fields on the request
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        // gettings all the fields error that were validated and binded to ex MethodArgumentNotValidException variable
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        // A list to contain all error message
        List<String> errList = new ArrayList<>();

        for (FieldError fieldError : errors) {
            errList.add(fieldError.getDefaultMessage());
        }
        
        // putting the error message into the errorResponse object
        ErrorResponse errqErrorResponse =  new ErrorResponse(errList);

        return new ResponseEntity<Object>(errqErrorResponse, HttpStatus.BAD_REQUEST);
    }

    //handles inValidated field error
    

}
