package com.Transylvania.Hotel_Transylvania.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String message){
        super(message);
    }
}
