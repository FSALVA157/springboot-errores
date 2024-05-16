package com.fsalva157.curso.springboot.error.springbooterror.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsalva157.curso.springboot.error.springbooterror.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private List<User> users;

    //public UserServiceImpl() {
        // this.users = new ArrayList<>();
        // this.users.add(new User(1L, "Fernando", "Salva"));
        // this.users.add(new User(2L, "Maria", "Gonzalez"));
        // this.users.add(new User(3L, "Pablo", "Lopez"));
        // this.users.add(new User(4L, "Jose", "Rodriguez"));
    //}

    @Override
    public List<User> getAll() {
        return this.users;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return this.users.stream().filter(user -> user.getId().equals(id)).findFirst();
        // User user = null;
        // for (User u : users) {
        //     if(u.getId().equals(id)) {
        //         user = u;
        //         break;
        //     }
        // }
        // return Optional.ofNullable(user);
    }

}
