package com.example.spring_api.service;

import com.example.spring_api.dto.RegisterRequest;
import com.example.spring_api.model.User;
import com.example.spring_api.repository.UserRepository;
import org.springframework.stereotype.Service;

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
}
