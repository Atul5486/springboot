package com.Basic_Authentication.exception;

import com.Basic_Authentication.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> exceptionResponse(Exception e){
        Response res=new Response("Something went wrong Try again\n"+e.getMessage(),null);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
