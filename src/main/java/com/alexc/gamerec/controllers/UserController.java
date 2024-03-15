package com.alexc.gamerec.controllers;

import com.alexc.gamerec.models.Rating;
import com.alexc.gamerec.models.User;
import com.alexc.gamerec.services.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServ userServ;

    //Read Operations
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> findUser(@PathVariable("id") Long id) {
        User user = userServ.findUserById(id);
        if(user != null) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}/ratings")
    @ResponseBody
    public ResponseEntity<List<Rating>> findRatings(@PathVariable("id") Long id) {
        User user = userServ.findUserById(id);
        if (user != null) {
            return new ResponseEntity<List<Rating>>(user.getUserRatings(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    //Create Operations
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userServ.createUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //Update Operations
    @PostMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        User updateUser = userServ.findUserById(id);
        if(user != null) {
            updateUser.setFirstName(user.getFirstName());
            updateUser.setLastName(user.getLastName());
            return new ResponseEntity<User>(userServ.updateUser(updateUser), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    //Delete Operations
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        User user = userServ.findUserById(id);
        if(user != null) {
            userServ.deleteUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
