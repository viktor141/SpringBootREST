package ru.vixtor.springbootrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.vixtor.springbootrest.exceptions.InvalidCredentials;
import ru.vixtor.springbootrest.exceptions.UnauthorizedUser;
import ru.vixtor.springbootrest.permission.Authorities;
import ru.vixtor.springbootrest.repository.UserRepository;

import java.util.List;
public class AuthorizationService {

    @Autowired
    UserRepository userRepository;


    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
