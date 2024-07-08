package com.example.The.Big.Project.repository;

import com.example.The.Big.Project.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
}
