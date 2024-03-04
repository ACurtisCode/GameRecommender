package com.alexc.gamerec.controllers;

import com.alexc.gamerec.models.Rating;
import com.alexc.gamerec.models.User;
import com.alexc.gamerec.services.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User findUser(@PathVariable("id") Long id) {
        User user = userServ.findUserById(id);
//        HashMap<String, Object> object = new HashMap<>();
//        object.put("id", user.getId());
//        object.put("firstName", user.getFirstName());
//        object.put("lastName", user.getLastName());
//        return object;
        return user;
    }
    @GetMapping("/{id}/ratings")
    @ResponseBody
    public List<Rating> findRatings(@PathVariable("id") Long id) {
        User user = userServ.findUserById(id);
        return user.getUserRatings();
    }

    //Create Operations
    @PostMapping("/create")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        userServ.createUser(user);
        return user;
    }

    //Update Operations
    @PostMapping("/update/{id}")
    @ResponseBody
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        User updateUser = userServ.findUserById(id);
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        return userServ.updateUser(updateUser);
    }

    //Delete Operations
    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        User user = userServ.findUserById(id);
        userServ.deleteUser(user);
    }
}
