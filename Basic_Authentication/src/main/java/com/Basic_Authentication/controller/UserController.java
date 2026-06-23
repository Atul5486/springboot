package com.Basic_Authentication.controller;

import com.Basic_Authentication.dto.UserDto;
import com.Basic_Authentication.entity.User;
import com.Basic_Authentication.repository.UserRepository;
import com.Basic_Authentication.service.MailService;
import com.Basic_Authentication.utils.Utils;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final MailService mailService;

    public UserController(UserRepository userRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    @GetMapping("/")
    public String index(){
        return "User index page";
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws MessagingException {
        User user=userRepository.findByUsername(userDto.getUsername());
        if(user==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }
        if(userDto.getRole()!=null){
            user.setRole(userDto.getRole());
        }
        userRepository.save(user);

        mailService.sendMail(user.getUsername(),"Profile Update",
                Utils.profileUpdateMail.formatted(
                        usernamePasswordAuthenticationToken.getName().split("@")[0],
                        userDto.getRole()
                ));

        return ResponseEntity.status(HttpStatus.OK).body("User profile updated updated Successfully");
    }


}
