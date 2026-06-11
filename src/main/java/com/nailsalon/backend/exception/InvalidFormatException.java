package com.nailsalon.backend.exception;

public class InvalidFormatException extends RuntimeException{
    public InvalidFormatException (String message){
        super(message);
    }
}
