package com.springsecurity.spring_security.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.spring_security.Repository.UserRepository;
import com.springsecurity.spring_security.entity.User;
import com.springsecurity.spring_security.service.UserService;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // return userRepository.save(user);
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        User existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser != null) {
            return "Login successful";
        }
        return "User not found";
    }
}
