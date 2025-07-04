package com.uvtech.springboot.util;

import lombok.Data;

@Data
public class ResponseStruture<T> {
    private String message;
   private T data;
   private int status;

}
