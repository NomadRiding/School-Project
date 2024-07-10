package com.example.The.Big.Project.repository;

import com.example.The.Big.Project.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;



    @Test
    public void findAll_users_userList(){
       List<User> userList = userRepository.findAll();
        System.out.println(userList);
        assertEquals(4, userList.size());
    }

    @Test
    public void findById_invalidId_userNotPresent() {
        Optional <User> userOptional = userRepository.findById(777);
        assertTrue(userOptional.isEmpty());
    }

}
