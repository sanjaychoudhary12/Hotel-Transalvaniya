package com.Transylvania.Hotel_Transylvania.exception;

public class UserNotFoundException extends RuntimeException {

    public  UserNotFoundException(String message){
        super(message);
    }
}
