package com.example.The.Big.Project.controller.impl;


import com.example.The.Big.Project.model.User;
import com.example.The.Big.Project.service.impl.UserService;
import com.example.The.Big.Project.service.interfaces.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    IUserService userService;

    //  ****************************************************  GET  ****************************************************

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }


    //  ****************************************************  POST  ****************************************************

    @PostMapping("/user/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@PathVariable Integer id, @RequestBody User user){
       userService.saveUser(user);
    }

    //  ****************************************************  PUT  ****************************************************


    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody @Valid User user, @PathVariable Integer id){
        userService.updateUser(user, id);
    }

    //  ****************************************************  DELETE  ****************************************************

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }



}
