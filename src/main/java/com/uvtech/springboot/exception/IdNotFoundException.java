package com.uvtech.springboot.exception;

public class IdNotFoundException extends RuntimeException {
    private String message="Employee with given id not found";
    public IdNotFoundException(){
    }
    @Override
    public String getMessage() {
        return message;
    }



}
