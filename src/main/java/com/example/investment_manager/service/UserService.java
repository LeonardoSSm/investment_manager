package com.example.investment_manager.service;

import com.example.investment_manager.model.UserModel;
import com.example.investment_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAllUsers(){
        return userRepository.findAll();
    }

    public Optional<UserModel> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserModel saveUser(UserModel userModel){
        return userRepository.save(userModel);
    }
}
