package com.Happyme.project.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.Happyme.project.entity.User;
import com.Happyme.project.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
     private UserService userservice;

    @PostMapping("/register")
    public User registeruser(@RequestBody User user) {
        return userservice.registeruser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> findUser(@PathVariable Long id) {
        return userservice.finduser(id);
    }
    
    @GetMapping("/{email}")
    public Optional<User> findUserbyemail(@PathVariable String email) {
        return userservice.finduserbyemail(email);
    }
}