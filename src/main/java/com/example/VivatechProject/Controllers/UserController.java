package com.example.VivatechProject.Controllers;

import com.example.VivatechProject.Models.User;
import com.example.VivatechProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private String currentOtp;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user){
        try {
            userService.add(user);
            return new ResponseEntity<>("User added Successfully", HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>("Some thing broke  " + e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @GetMapping("/send-otp")
    public ResponseEntity<String> sendOtp(){
        String otp =  userService.sendOtp();
        currentOtp = otp;
        return new ResponseEntity<>(otp+"  Otp sent to mobile number successfully.",HttpStatus.OK);
    }
    @GetMapping("check-otp")
    public ResponseEntity<String> validateOtp( @RequestParam ("otp") String otp){

            if(otp.equals(currentOtp)) return new ResponseEntity<>("Otp Verified",HttpStatus.FOUND);

            return new ResponseEntity<>("Invalid Otp encountered", HttpStatus.NOT_FOUND);
    }
}
