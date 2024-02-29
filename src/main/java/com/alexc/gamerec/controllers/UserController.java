package com.alexc.gamerec.controllers;

import com.alexc.gamerec.models.User;
import com.alexc.gamerec.services.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServ userServ;

    @GetMapping("/{id}")
    @ResponseBody
    public Object findUser(@PathVariable("id") Long id) {
        User user = userServ.findUserById(id);
        HashMap<String, Object> object = new HashMap<>();
        object.put("id", user.getId());
        object.put("firstName", user.getFirstName());
        object.put("lastName", user.getLastName());
        return object;
    }

    @PostMapping("/create")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        userServ.createUser(user);
        return user;
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        User updateUser = userServ.findUserById(id);
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        return userServ.updateUser(updateUser);
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        User user = userServ.findUserById(id);
        userServ.deleteUser(user);
    }
}
