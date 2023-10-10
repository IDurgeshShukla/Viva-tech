package com.example.VivatechProject.Config;

import com.example.VivatechProject.Dtos.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
public class AppConfig{
    @Bean
    public UserDetailsService userDetailService(){
        UserDetails user = User.builder().username("Durgesh").password(passwordEncoder().encode("13456")).roles("Admin").build();
        UserDetails user1 =
                User.builder().username("Sneha").password(passwordEncoder().encode("13456")).roles("Admin").build();
        UserDetails user2 = User.builder().username("Maneesh").password(passwordEncoder().encode("13456")).roles(
                "Admin").build();
        UserDetails user3 = User.builder().username("Mouni").password(passwordEncoder().encode("13456")).roles(
                "Admin").build();

        return new InMemoryUserDetailsManager(user,user1,user2,user3);

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception{
        return builder.getAuthenticationManager();
    }
}
