package com.example.carpark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = NotFoundException.class)
    public Map<String,String> hendlerEmployeeException(NotFoundException ex){
        Map<String,String> map = new HashMap<>();
        map.put("errorMassage",ex.getMessage());
        return map;
    }
    @ExceptionHandler(value = ExistedExcepttion.class)
    public Map<String,String> hendlerExistedExcepttion(ExistedExcepttion ex){
        Map<String,String> map = new HashMap<>();
        map.put("errorMassage",ex.getMessage());
        return map;
    }
    @ExceptionHandler(value = NotForeignKeyException.class)
    public Map<String,String> hendlerNotForignKeyExcepttion(NotForeignKeyException ex){
        Map<String,String> map = new HashMap<>();
        map.put("errorMassage",ex.getMessage());
        return map;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


}
