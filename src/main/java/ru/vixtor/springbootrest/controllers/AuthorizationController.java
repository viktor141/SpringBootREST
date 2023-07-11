package ru.vixtor.springbootrest.controllers;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vixtor.springbootrest.domain.User;
import ru.vixtor.springbootrest.exceptions.InvalidCredentials;
import ru.vixtor.springbootrest.exceptions.UnauthorizedUser;
import ru.vixtor.springbootrest.permission.Authorities;
import ru.vixtor.springbootrest.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class AuthorizationController {
    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuHandler(UnauthorizedUser exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.valueOf(401));
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials exception){
        LoggerFactory.getLogger(AuthorizationController.class).error(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.valueOf(400));
    }
}
