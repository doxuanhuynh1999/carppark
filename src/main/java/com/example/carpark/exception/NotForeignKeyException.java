package com.example.carpark.exception;

public class NotForeignKeyException extends RuntimeException{
    public NotForeignKeyException(String message) {
        super(message);
    }
}
