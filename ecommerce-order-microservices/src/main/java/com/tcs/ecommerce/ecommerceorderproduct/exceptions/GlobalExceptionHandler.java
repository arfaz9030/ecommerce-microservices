package com.tcs.ecommerce.ecommerceorderproduct.exceptions;

import com.tcs.ecommerce.ecommerceorderproduct.payloads.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

//Refer project: ranga's udemy course refer github
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException){
    String message = resourceNotFoundException.getMessage();
//        new ApiResponse(message, false);
        return new ResponseEntity<ApiResponse>(new ApiResponse(message, false), HttpStatus.NOT_FOUND);
    }


    //	this is existing method to override and provide proper message for validation like username, password etc., fields are not working

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ApiResponse errorDetails = new ApiResponse(LocalDateTime.now(),"Total Errors:" + ex.getErrorCount() + " First Error:" + ex.getFieldError().getDefaultMessage(), request.getDescription(false));
        System.out.println("I am error Detail Object "+errorDetails);
        return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
