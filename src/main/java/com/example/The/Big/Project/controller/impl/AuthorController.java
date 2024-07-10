package com.example.The.Big.Project.controller.impl;

import com.example.The.Big.Project.controller.interfaces.IAuthorController;
import com.example.The.Big.Project.service.interfaces.IAuthorService;
import com.example.The.Big.Project.repository.AuthorRepository;
import com.example.The.Big.Project.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController implements IAuthorController {

    @Autowired
    IAuthorService authorService;


    //  ****************************************************  GET  ****************************************************

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable Integer id){
        return authorService.getAuthorById(id);
    }

    //  ****************************************************  POST  ****************************************************

    public Author createAuthor(@PathVariable Integer authorId, @RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    //  ****************************************************  DELETE  ****************************************************

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Integer id){
        authorService.deleteAuthor(id);
    }
}
