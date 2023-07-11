package ru.vixtor.springbootrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.vixtor.springbootrest.repository.UserRepository;
import ru.vixtor.springbootrest.resolver.UserArgumentResolver;
import ru.vixtor.springbootrest.service.AuthorizationService;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebMvcContext implements WebMvcConfigurer {

    @Bean
    public AuthorizationService authorizationService(){
        return new AuthorizationService();
    }

    @Bean
    public UserRepository UserRepository(){
        return new UserRepository();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserArgumentResolver());
    }
}
