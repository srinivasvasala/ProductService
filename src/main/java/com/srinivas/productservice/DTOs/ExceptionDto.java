package com.srinivas.productservice.DTOs;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

    @Getter
    @Setter
    public class ExceptionDto {
        private HttpStatus httpStatus;
        private String message;
    }
