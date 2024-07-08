package com.example.The.Big.Project.controller.impl;

import com.example.The.Big.Project.controller.interfaces.IAuthorController;
import com.example.The.Big.Project.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController implements IAuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

}
