package com.uvtech.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.uvtech.springboot.util.ResponseStruture;

@RestControllerAdvice
public class ApplicationExceptionHandler {
     
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseStruture<String>> handleNOtFoundException(IdNotFoundException exception){
      ResponseStruture<String> struture=new ResponseStruture<>();
      struture.setMessage(exception.getMessage());
      struture.setStatus(HttpStatus.NOT_FOUND.value());
      struture.setData("Employee with given id not found! enter a valid ID");
      return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoDataFoundException.class)
     public ResponseEntity<ResponseStruture<String>> handleNOtFoundException(NoDataFoundException exception){
      ResponseStruture<String> struture=new ResponseStruture<>();
      struture.setMessage(exception.getMessage());
      struture.setStatus(HttpStatus.NOT_FOUND.value());
      struture.setData("Empty");
      return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.NOT_FOUND);
    }
}
