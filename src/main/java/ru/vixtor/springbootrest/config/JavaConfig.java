package ru.vixtor.springbootrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.vixtor.springbootrest.repository.UserRepository;
import ru.vixtor.springbootrest.service.AuthorizationService;

@Configuration
public class JavaConfig {

    @Bean
    public AuthorizationService authorizationService(){
        return new AuthorizationService();
    }

    @Bean
    public UserRepository UserRepository(){
        return new UserRepository();
    }
}
