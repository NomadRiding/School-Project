package com.example.The.Big.Project.service.impl;

import com.example.The.Big.Project.model.User;
import com.example.The.Big.Project.repository.UserRepository;
import com.example.The.Big.Project.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {



    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public void updateUser(User user, Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not found.");
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not found.");
        userRepository.deleteById(id);
    }

}
