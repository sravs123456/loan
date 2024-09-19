package com.neoteric.fullstackdemo_310824.exception;

public class AccountCreationFailedException extends Exception{

    public String message;


    public AccountCreationFailedException(String message){
        this.message=message;
    }






}
