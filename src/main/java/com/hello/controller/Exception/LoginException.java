package com.hello.controller.Exception;

public class LoginException extends RuntimeException {
    public LoginException(){}

    public LoginException(String message){
        super(message);
    }
}
