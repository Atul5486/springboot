package com.Basic_Authentication.controller;

import com.Basic_Authentication.dto.UserDto;
import com.Basic_Authentication.entity.OTP;
import com.Basic_Authentication.entity.User;
import com.Basic_Authentication.repository.OTPRepository;
import com.Basic_Authentication.repository.UserRepository;
import com.Basic_Authentication.service.MailService;
import com.Basic_Authentication.service.UserService;
import com.Basic_Authentication.utils.JWTUtils;
import com.Basic_Authentication.utils.Response;
import com.Basic_Authentication.utils.Utils;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserService userService;
    private final UserRepository userRepository;
    private final JWTUtils jwtUtils;
    private final OTPRepository otpRepository;
    private final MailService mailService;

    private Response res=new Response();


    public AuthController(UserService userService, UserRepository userRepository, JWTUtils jwtUtils, OTPRepository otpRepository, MailService mailService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.otpRepository = otpRepository;
        this.mailService = mailService;
    }

    @GetMapping("/")
    public String index(){
        return "Auth Index page";
    }

    @PostMapping("/signup")
    public ResponseEntity<Response> signupUser(@RequestBody UserDto userDto) throws MessagingException {
           if(userDto.getUsername().isBlank() || userDto.getPassword().isBlank() || userDto.getRole().isBlank()){
               res.setMessage("All Field required");
               return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
           }

           User existUser=userRepository.findByUsername(userDto.getUsername());

           if(existUser!=null){
               res.setMessage("User already exists");
               res.setRes(null);
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
           }

           User newUser=userService.createUser(userDto);
           res.setRes(newUser);

           jwtUtils.generateOtp();


        OTP otpObj=new OTP();
        otpObj.setUsername(newUser.getUsername());
        otpObj.setOtp(jwtUtils.generateOtp()+"");
        otpRepository.save(otpObj);

        mailService.sendMail(newUser.getUsername(),"OTP Verification",
                Utils.otpMail.formatted(otpObj.getOtp()));

        res.setMessage("OTP Sent successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PostMapping("/login")
    public ResponseEntity<Response> loginUser(@RequestBody UserDto userDto){
        User user=userRepository.findByUsername(userDto.getUsername());
        res.setRes(null);
        if(user==null){
            res.setMessage("User Not found");
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        if(!passwordEncoder.matches(userDto.getPassword(), user.getPassword())){
            res.setMessage("Invalid credential");
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        if(!user.isActive()){
            res.setMessage("Please verify your email with otp");
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        String token=jwtUtils.generateToken(user.getUsername(),user.getRole());
        res.setMessage("Login successfully");
        res.setRes(token);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestBody String otp){
        OTP otpObj=otpRepository.findByOtp(otp);

        if(otpObj==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP");
        }
        User user=userRepository.findByUsername(otpObj.getUsername());
        user.setActive(true);
        userRepository.save(user);
        otpRepository.delete(otpObj);
        return ResponseEntity.status(HttpStatus.OK).body("Otp Verify Successfully. Now you can login");
    }

}
