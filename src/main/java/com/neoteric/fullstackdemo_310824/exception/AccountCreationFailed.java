package com.neoteric.fullstackdemo_310824.exception;

public class AccountCreationFailed extends Exception{

    public String message;


    public AccountCreationFailed(String message){
        this.message=message;
    }






}
