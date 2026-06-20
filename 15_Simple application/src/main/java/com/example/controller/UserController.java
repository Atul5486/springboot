package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String index(){
        return "Index page";
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User u=userService.createUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        User u=userService.getUser(id);
        return  ResponseEntity.status(HttpStatus.OK).body(u);
    }

    @DeleteMapping("/user")
    public ResponseEntity<String> createUser(@RequestParam int id){
        String s=userService.deleteUser(id);
        return  ResponseEntity.status(HttpStatus.OK).body(s);
    }
    @PatchMapping("/user/{id}")
    public ResponseEntity<User> createUser(@RequestBody User user,@PathVariable int id){
        User u=userService.updateUser(id,user);
        return  ResponseEntity.status(HttpStatus.OK).body(u);
    }

    @GetMapping("/user-all")
    public ResponseEntity<List<User>> createUser(){
        List<User> u=userService.getAllUser();
        return  ResponseEntity.status(HttpStatus.CREATED).body(u);
    }
}
