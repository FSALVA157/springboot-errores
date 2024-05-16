package com.fsalva157.curso.springboot.error.springbooterror.Services;

import java.util.List;
import java.util.Optional;

import com.fsalva157.curso.springboot.error.springbooterror.models.domain.User;

public interface UserService {
    List<User> getAll();

    Optional<User> findUserById(Long id);
    
}
