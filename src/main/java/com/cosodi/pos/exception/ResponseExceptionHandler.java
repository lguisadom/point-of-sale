package com.cosodi.pos.exception;

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
import java.util.stream.Collectors;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomerErrorResponse> handleAllException(Exception ex, WebRequest request) {
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        // return ResponseEntity.internalServerError().body(customerErrorResponse);
        return new ResponseEntity<>(customerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomerErrorResponse> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(customerErrorResponse, HttpStatus.NOT_FOUND);
    }

    /*@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = ex.getBindingResult().getAllErrors().stream().map(
                e -> e.getCode().concat(":").concat(e.getDefaultMessage())
        ).collect(Collectors.joining());
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(LocalDateTime.now(), message, request.getDescription(false));
        return new ResponseEntity<>(customerErrorResponse, HttpStatus.BAD_REQUEST);
    }*/
}
