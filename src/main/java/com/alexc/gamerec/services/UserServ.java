package com.alexc.gamerec.services;

import com.alexc.gamerec.models.User;
import com.alexc.gamerec.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServ {
    @Autowired
    UserRepo repo;

    public User createUser(User user) {
        return repo.save(user);
    }

    public User createUser(String firstName, String lastName) {
        return repo.save(new User(firstName, lastName));
    }

    public User findUserById(Long id) {
        if(repo.findById(id).isEmpty()){
            return null;
        }
        return repo.findById(id).get();
    }

    public User updateUser(User user) {
        return repo.save(user);
    }

    public void deleteUser(User user) {
        repo.delete(user);
    }
}
