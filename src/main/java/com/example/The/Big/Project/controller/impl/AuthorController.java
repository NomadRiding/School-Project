package com.example.The.Big.Project.controller.impl;

import com.example.The.Big.Project.controller.interfaces.IAuthorController;
import com.example.The.Big.Project.service.interfaces.IAuthorService;
import com.example.The.Big.Project.repository.AuthorRepository;
import com.example.The.Big.Project.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController implements IAuthorController {

    @Autowired
    AuthorRepository authorRepository;


    //  ****************************************************  GET  ****************************************************

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable Integer id){
        return authorRepository.getAuthorById(id);
    }

}
