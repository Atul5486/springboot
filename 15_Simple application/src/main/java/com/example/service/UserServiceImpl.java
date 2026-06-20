package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
           return userRepository.save(user);
    }

    @Override
    public User updateUser(int id,User user) {
        User u=userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        u.setName(user.getName());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        userRepository.save(u);
        return null;
    }

    @Override
    public String deleteUser(int id) {
        User u=userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
         userRepository.delete(u);
         return "User deleted successfully";
    }

    @Override
    public User getUser(int id) {
       return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
