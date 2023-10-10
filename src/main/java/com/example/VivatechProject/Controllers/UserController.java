package com.example.VivatechProject.Controllers;
import org.springframework.security.core.userdetails.User;
import com.example.VivatechProject.Dtos.UserDto;
import com.example.VivatechProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

   @GetMapping("/showUsers")
    public ResponseEntity<List<UserDetails>> getUsers(){
        try{
            List<UserDetails> users = userService.getUsers();
            return new ResponseEntity<>(users,HttpStatus.FOUND);
        }
       catch (Exception e){
            return new ResponseEntity<List<UserDetails>>(HttpStatus.NOT_FOUND);
       }
   }
}
