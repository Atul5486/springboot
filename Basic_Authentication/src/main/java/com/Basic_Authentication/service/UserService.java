package com.Basic_Authentication.service;

import com.Basic_Authentication.dto.UserDto;
import com.Basic_Authentication.entity.User;
import com.Basic_Authentication.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private  UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(UserDto userDto){
        User u= userRepository.findByUsername(userDto.getUsername());
        if(u!=null){
            return u;
        }
        User user=new User();
        user.setUsername(userDto.getUsername());
        user.setRole(userDto.getRole());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

}
