package com.uvtech.springboot.exception;

public class NoDataFoundException extends RuntimeException {
    private String message="No Data Found";
    public NoDataFoundException(){

    }
    public String getMessage(){
        return message;
    }


}
