package com.ltp.contacts;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    
    // @Override
    // protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
    //         HttpHeaders headers, HttpStatus status, WebRequest request) {
    //     // TODO Auto-generated method stub
    //     for (ObjectError error : ex.getBindingResult().getAllErrors()) {
    //         System.out.println(error.getDefaultMessage());
    //     }

        
    //     //return super.handleMethodArgumentNotValid(ex, headers, status, request);
    //     return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
    // }

    // @ExceptionHandler
    // public ResponseEntity<Object> handlerContactNotFoundException() {
    //     ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
    //     return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);

    // }
}
