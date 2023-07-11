package ru.vixtor.springbootrest.repository;

import org.springframework.stereotype.Repository;
import ru.vixtor.springbootrest.permission.Authorities;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        if(user.equals("admin") && password.equals("admin"))return List.of(Authorities.values());

        if(user.equals("user") && password.equals("pass"))return List.of(Authorities.READ);

        if(user.equals("author") && password.equals("authorpass"))return List.of(Authorities.READ, Authorities.WRITE);

        return new ArrayList<>();
    }
}
