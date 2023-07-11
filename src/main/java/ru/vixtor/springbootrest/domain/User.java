package ru.vixtor.springbootrest.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

    @NotBlank
    @Size(min = 1, max = 16)
    private final String name;
    @NotBlank
    @Size(min = 8, max = 24)
    private final String password;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
