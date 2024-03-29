package com.example.VivatechProject.Services;

import com.example.VivatechProject.Dtos.UserDto;
import com.example.VivatechProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDetails> getUsers()  {
        List<UserDetails> users = new ArrayList<>();
        UserDetails user = User.builder().username("Durgesh").password(passwordEncoder().encode("13456")).roles("Admin").build();
        UserDetails user1 =
                User.builder().username("Sneha").password(passwordEncoder().encode("13456")).roles("Admin").build();
        UserDetails user2 = User.builder().username("Maneesh").password(passwordEncoder().encode("13456")).roles(
                "Admin").build();
        UserDetails user3 = User.builder().username("Mouni").password(passwordEncoder().encode("13456")).roles(
                "Admin").build();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
