package com.fsalva157.curso.springboot.error.springbooterror.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fsalva157.curso.springboot.error.springbooterror.Services.UserService;
import com.fsalva157.curso.springboot.error.springbooterror.exceptions.UserNotFoundException;
import com.fsalva157.curso.springboot.error.springbooterror.models.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    UserService userService;

    @GetMapping    
    public String index(){
        //int value = 100/0;        
        int value = Integer.parseInt("1001x");
        return "Hola Mundo " + value;
    }

    @GetMapping("/user/{id}")
    public User userById(
        @PathVariable(name="id")
         Long id
         ) {
        // Class<?> tipoParametro = id.getClass();
        // System.out.println(tipoParametro);
        User user = this.userService.findUserById(id).orElseThrow(() -> new UserNotFoundException("El Usuario no figura en Base de Datos!!!"));
        // if(user == null) {
        //     throw new UserNotFoundException("El Usuario no Existe!!!");
        // }
        //System.out.println(user.getRoleName());
        return user;
    }
    
    

}
