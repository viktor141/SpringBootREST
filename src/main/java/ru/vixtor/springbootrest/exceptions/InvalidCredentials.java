package ru.vixtor.springbootrest.exceptions;

public class InvalidCredentials extends RuntimeException{

    public InvalidCredentials(String msg) {
        super(msg);
    }
}
