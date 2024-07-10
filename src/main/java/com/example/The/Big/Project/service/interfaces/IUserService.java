package com.example.The.Big.Project.service.interfaces;

import com.example.The.Big.Project.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    List<User> getAllUsers();

    User saveUser(User user);

    void updateUser(User user, Integer id);

    void deleteUser(Integer id);

    User getUserById(Integer id);
}
