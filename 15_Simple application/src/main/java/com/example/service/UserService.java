package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);
    public User updateUser(int id,User user);
    public String deleteUser(int id);
    public User getUser(int id);
    public List<User> getAllUser();

}
