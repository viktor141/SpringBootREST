package ru.vixtor.springbootrest.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class UnauthorizedUser extends RuntimeException{

    public UnauthorizedUser(String msg) {
        super(msg);
    }
}
