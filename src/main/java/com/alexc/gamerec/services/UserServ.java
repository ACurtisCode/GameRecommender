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

    public User findUserById(Long id) {
            return repo.findById(id).get();
    }
}
