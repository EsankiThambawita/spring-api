package com.example.spring_api.service;

import com.example.spring_api.dto.LoginRequest;
import com.example.spring_api.dto.RegisterRequest;
import com.example.spring_api.model.User;
import com.example.spring_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    //dependency injection
    private UserRepository userRepository;

    //Constructor Injection
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(RegisterRequest registerRequest){
        if(userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email is already taken");
        }

        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());

        userRepository.save(user);
    }

    public String login(LoginRequest loginRequest){

        // Find user by email
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());

        if(userOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }

        // Get the user and compare password
        User user = userOptional.get();
        if(!user.getPassword().equals(loginRequest.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return "Login Successful !"
    }


}
