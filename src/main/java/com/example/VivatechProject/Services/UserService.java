package com.example.VivatechProject.Services;

import com.example.VivatechProject.Models.User;
import com.example.VivatechProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void add(User user) throws Exception {
        Optional<User> userOptional = userRepository.findById(user.getMobileNo());
        if (userOptional.isPresent()) throw new Exception("User is already present");
        else userRepository.save(user);
    }
// create 4-digit otp
    public String sendOtp() {
        Random random = new Random();
        int otp = 1000 + random.nextInt(9000); // Generates a random 4-digit number between 1000 and 9999
        return String.format("%04d", otp); // Ensure that the OTP is always 4 digits with leading zeros if needed
    }

}
