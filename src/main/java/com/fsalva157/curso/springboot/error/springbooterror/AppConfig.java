package com.fsalva157.curso.springboot.error.springbooterror;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fsalva157.curso.springboot.error.springbooterror.models.domain.User;

@Configuration
public class AppConfig {

    @Bean    
    List<User> users(){
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "John", "Doe"));
        users.add(new User(2L, "Jane", "Doe"));
        users.add(new User(3L, "Juan", "Diaz"));
        users.add(new User(4L, "Maria", "Rodriguez"));
        return users;
    }

}
